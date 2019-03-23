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
	public Trip addTrip(Trip trip) {
		return tripRepository.save(trip);
		
	}

	@Override
	public List<Trip> getTripsByLocationName(String name) {
		return tripRepository.getTripsByLocationName(name);
	}

	@Override
	public List<Trip> getTripsByLocationId(Integer id) {
		// TODO Auto-generated method stub
		return tripRepository.getTripsByLocationId(id);
	}


}
