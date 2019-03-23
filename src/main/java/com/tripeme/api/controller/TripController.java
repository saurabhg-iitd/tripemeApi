package com.tripeme.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.bo.Location;
import com.tripeme.api.bo.Theme;
import com.tripeme.api.bo.Trip;
import com.tripeme.api.request.TripRequest;
import com.tripeme.api.service.LocationService;
import com.tripeme.api.service.ThemeService;
import com.tripeme.api.service.TripService;

@RestController
public class TripController {
	@Autowired
	TripService tripService;
	
	@Autowired
	ThemeService themeService;
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/trip/{id}")
    public Trip getTrip(@PathVariable Long id) {
		return tripService.getTripById(id);
	}
	
	@PostMapping("/trip")
	public Trip addTrip(@RequestBody TripRequest request) {
		Theme theme = themeService.getThemeById(request.getThemeId());
		Location location = locationService.getLocationById(request.getLocationId());
		Trip trip = new Trip();
		trip.setCreatedOn(new Date());
		trip.setUpdatedOn(new Date());
		trip.setTheme(theme);
		trip.setEndDate(request.getEndDate());
		trip.setStartDate(request.getStartDate());
		trip.setMaxBookings(request.getMaxBookings());
		trip.setLocation(location);
		return tripService.addTrip(trip);
	}
	
	@GetMapping("/trip/location/{name}")
	public List<Trip> getTripsByLocationName(@PathVariable String name) {
		return tripService.getTripsByLocationName(name);
		
	}
	
	@GetMapping("/trip/locationId/{id}")
	public List<Trip> getTripsByLocationId(@PathVariable Integer id) {
		return tripService.getTripsByLocationId(id);
		
	}

	
}
