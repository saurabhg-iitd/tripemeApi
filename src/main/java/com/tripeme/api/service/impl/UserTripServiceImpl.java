package com.tripeme.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.request.UserTripRequest;
import com.tripeme.api.bo.Trip;
import com.tripeme.api.bo.User;
import com.tripeme.api.bo.UserTrip;
import com.tripeme.api.bo.UserTripId;
import com.tripeme.api.enums.UserTripStatus;
import com.tripeme.api.repository.TripRepository;
import com.tripeme.api.repository.UserRepository;
import com.tripeme.api.repository.UserTripRepository;
import com.tripeme.api.service.UserTripService;

@Service
public class UserTripServiceImpl implements UserTripService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	UserTripRepository userTripRepository;
	

	@Override
	public UserTrip saveUserTrip(UserTrip userTrip) {
		// TODO Auto-generated method stub
		return userTripRepository.save(userTrip);
	}


	@Override
	public List<UserTrip> getUserTrip(Long userId, Long tripId) {
		// TODO Auto-generated method stub
		User user = userRepository.getOne(userId);
		Trip trip = tripRepository.getOne(tripId);
		Optional<UserTrip> userTrips = userTripRepository.findById(new UserTripId(user,trip));
		List<UserTrip> result = new ArrayList<>();
		if(userTrips.isPresent()) {
			result = (List<UserTrip>) userTrips.get();
		}
		return result;
	}


	@Override
	public User getUserAllTrips(Long userId) {
		return userRepository.getOne(userId);
	}


	@Override
	public UserTrip addUserTrip(UserTripRequest request) {
		User user = userRepository.getOne(request.getUserId());
		Trip trip = tripRepository.getOne(request.getTripId());
		UserTrip userTrip = new UserTrip();
		userTrip.setPk(new UserTripId(user,trip));
		userTrip.setTotalBookings(request.getTotalBookings());
		userTrip.setUserTripStatus(UserTripStatus.added);
		userTrip.setCreateOn(new Date());
		
		return userTripRepository.save(userTrip);
	}

}
