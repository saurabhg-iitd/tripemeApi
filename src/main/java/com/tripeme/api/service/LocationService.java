package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.bo.Location;

public interface LocationService {
	Location addLocation(Location location);
	Location getLocationByName(String location);
	Location getLocationById(Integer locationId);
	List<Location> getLocationsHavingTrips();
	List<Location> getAllLocations();

}
