package com.tripeme.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.UserSession;
import com.tripeme.api.repository.UserSessionRepository;
import com.tripeme.api.service.UserSessionService;

@Service
public class UserSessionServiceImpl implements UserSessionService {
	@Autowired
	UserSessionRepository userSessionRepositry;
	
	@Override
	public UserSession getUserSession(String sessionId) {
		// TODO Auto-generated method stub
		return userSessionRepositry.getOne(sessionId);
	}

	@Override
	public UserSession saveSession(UserSession userSession) {
		// TODO Auto-generated method stub
		return userSessionRepositry.save(userSession);
	}

}
