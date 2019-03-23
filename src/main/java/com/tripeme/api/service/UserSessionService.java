package com.tripeme.api.service;

import com.tripeme.api.bo.UserSession;

public interface UserSessionService {
	UserSession getUserSession(String sessionId);
	UserSession saveSession(UserSession userSession);
}
