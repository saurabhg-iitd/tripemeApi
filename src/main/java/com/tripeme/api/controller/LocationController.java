package com.tripeme.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.bo.Location;
import com.tripeme.api.service.LocationService;

@RestController()
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	/*@GetMapping("/location/{location}")
	Location getLocationByName(@PathVariable String location) {
		return locationService.getLocationByName(location);
	}*/
	
	@GetMapping("/location/{id}")
	Location getLocationById(@PathVariable Integer id) {
		return locationService.getLocationById(id);
	}
	
	@PostMapping("/location")
	Location addTheme(@RequestBody Location location) {
		return locationService.addLocation(location);
	}
	
	@GetMapping("/location")
	List<Location> getAllLocations(){
		return locationService.getAllLocations();
	}
	
	@GetMapping("/location/trip")
	List<Location> getLocationsHavingTrips(){
		return locationService.getLocationsHavingTrips();
	}
	

}
