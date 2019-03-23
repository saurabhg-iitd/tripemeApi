package com.tripeme.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.Location;
import com.tripeme.api.repository.LocationRepository;
import com.tripeme.api.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	LocationRepository locationRepository;

	@Override
	public Location addLocation(Location location) {

		return 	locationRepository.save(location);
	}

	@Override
	public Location getLocationByName(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	@Override
	public Location getLocationById(Integer locationId) {
		// TODO Auto-generated method stub
		return locationRepository.getOne(locationId);
	}
	
	public List<Location> getLocationsHavingTrips(){
		return locationRepository.getLocationsHavingTrips();
	}

}
