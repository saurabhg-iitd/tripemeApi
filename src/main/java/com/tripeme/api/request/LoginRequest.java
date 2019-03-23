package com.tripeme.api.request;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.tripeme.api.enums.LoginType;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LoginRequest {
	
	String displayName;
	String email;
	Long userId;
	Long loginId;
	LoginType loginType;
	String imageUrl;
	String accessToken;
	String idToken;
	String serverAuthCode;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public LoginType getLoginType() {
		return loginType;
	}
	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	public String getServerAuthCode() {
		return serverAuthCode;
	}
	public void setServerAuthCode(String serverAuthCode) {
		this.serverAuthCode = serverAuthCode;
	}
	
	

}
