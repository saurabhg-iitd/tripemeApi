package com.tripeme.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyCustomInterceptor implements HandlerInterceptor{

    //unimplemented methods comes here. Define the following method so that it     
    //will handle the request before it is passed to the controller.

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse  response, Object handler){
    //your custom logic here.
    	System.out.println(request.getCookies());
    	Cookie[] cookies = request.getCookies();
    	if(cookies!=null) {
    		System.out.println(cookies[0]);
    	}
        return true;
    }
}
