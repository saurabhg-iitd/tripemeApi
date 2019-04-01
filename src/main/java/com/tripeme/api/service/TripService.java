package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.bo.Trip;

public interface TripService {
	Trip getTripById(Long tripid);
	Trip saveTrip(Trip trip);
	List<Trip> getTripsByDestinationId(Long id);
	List<Trip> getTripsByDestinationName(String name);
	List<Trip> getAllTrips();
}
