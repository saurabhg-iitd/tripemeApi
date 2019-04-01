package com.tripeme.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.request.UserTripRequest;
import com.tripeme.api.response.UserTripResponse;
import com.tripeme.api.bo.User;
import com.tripeme.api.bo.UserTrip;
import com.tripeme.api.service.UserTripService;;

@RestController
@RequestMapping("user/trip")
public class UserTripController {
	@Autowired
	UserTripService userTripService;
	
	@GetMapping("/{userId}/{tripId}")
	List<UserTrip> getUserTrip(@PathVariable Long userId,  @PathVariable Long tripId) {
		return userTripService.getUserTrip(userId, tripId);
	}
	@GetMapping("/{userId}")
	User getUserAllTrips(@PathVariable Long userId){
		return userTripService.getUserAllTrips(userId);
	}
	
	@PostMapping()
	UserTripResponse addUserTrip(@RequestBody UserTripRequest request) {
		return userTripService.addUserTrip(request);
	}

}
