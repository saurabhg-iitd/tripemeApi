package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.request.UserTripRequest;
import com.tripeme.api.response.UserTripResponse;
import com.tripeme.api.bo.User;
import com.tripeme.api.bo.UserTrip;

public interface UserTripService {
	UserTrip saveUserTrip(UserTrip userTrip);
	List<UserTrip> getUserTrip(Long userId, Long tripId);
	User getUserAllTrips(Long userId);
	UserTripResponse addUserTrip(UserTripRequest request);

}
