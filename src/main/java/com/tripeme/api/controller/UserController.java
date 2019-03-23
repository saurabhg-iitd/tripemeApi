package com.tripeme.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.bo.User;
import com.tripeme.api.bo.UserSession;
import com.tripeme.api.enums.LoginType;
import com.tripeme.api.request.LoginRequest;
import com.tripeme.api.response.UserSessionResponse;
import com.tripeme.api.service.UserService;
import com.tripeme.api.service.UserSessionService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserSessionService userSessionService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestBody User user) {

		user.setCreateOn(new Date());
		user.setUpdateOn(new Date());
        userService.save(user);

        /*securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());*/

        return "success";
    }
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public UserSessionResponse authenticateUser(@RequestBody LoginRequest loginRequest) throws IOException, JSONException {
		String url = "https://oauth2.googleapis.com/tokeninfo?id_token=";
		url = url + loginRequest.getIdToken();
		String mobileClientId="708238941640-ku3asp6fvvn19fajhhllsn4bv9dh1tnj.apps.googleusercontent.com";

		String weblientId="708238941640-2gk1fqo1fpthkpbghpv3500m07g0r1m2.apps.googleusercontent.com";
		UserSessionResponse response = new UserSessionResponse();
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer result = new StringBuffer();
		String line;
		while ((line = in.readLine()) != null) {
			result.append(line);
		}
		
		JSONObject jsonObj = new JSONObject(result.toString());
		if(jsonObj.getString("azp").equals(weblientId)) {
			try {
				User user = userService.findByEmailId(jsonObj.getString("email"));
				if(user==null) {
					user = new User();
					user.setAdmin(false);
					user.setCreateOn(new Date());
					user.setEmailId(jsonObj.getString("email"));
					user.setImageUrl(jsonObj.getString("picture"));
					user.setName(jsonObj.getString("name"));
					user.setLoginTpye(LoginType.GOOGLE);
					user.setLoginId(jsonObj.getLong("sub"));
					user = userService.save(user);
					System.out.println("createUser");
				}
				UserSession userSession = new UserSession();
				userSession.setEmailId(user.getEmailId());
				userSession.setName(user.getName());
				userSession.setUser(user);
				userSession = userSessionService.saveSession(userSession);
				System.out.println("create Session");
				
				response.setAdmin(user.getAdmin());
				response.setEmailId(user.getEmailId());
				response.setName(user.getName());
				response.setImgUrl(user.getImageUrl());
				response.setSessionId(userSession.getSessionId());
				response.setUserId(user.getUserId());
				
			} catch (JSONException e) {
				// TODO: handle exception
			}
		}
		return response;
		
	}
}
