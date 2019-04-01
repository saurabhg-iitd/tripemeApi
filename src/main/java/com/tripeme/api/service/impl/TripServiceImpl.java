package com.tripeme.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.Trip;
import com.tripeme.api.repository.TripRepository;
import com.tripeme.api.service.TripService;

@Service
public class TripServiceImpl implements TripService{
	
	@Autowired
	TripRepository tripRepository;

	@Override
	public Trip getTripById(Long tripId) {
		return tripRepository.getOne(tripId);
	}

	@Override
	public Trip saveTrip(Trip trip) {
		return tripRepository.save(trip);
		
	}
	

	@Override
	public List<Trip> getTripsByDestinationName(String name) {
		return tripRepository.getTripsByDestinationName(name);
	}

	@Override
	public List<Trip> getTripsByDestinationId(Long id) {
		// TODO Auto-generated method stub
		return tripRepository.getTripsByDestinationId(id);
	}

	@Override
	public List<Trip> getAllTrips() {
		return tripRepository.findAll();
	}


}
