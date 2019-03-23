package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.bo.Trip;

public interface TripService {
	Trip getTripById(Long tripid);
	Trip addTrip(Trip trip);
	List<Trip> getTripsByLocationId(Integer id);
	List<Trip> getTripsByLocationName(String name);
}
