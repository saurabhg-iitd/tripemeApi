package com.tripeme.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.bo.Destination;
import com.tripeme.api.service.DestinationService;

@RestController()
public class DestinationController {
	
	@Autowired
	DestinationService destinationService;
	
	
	
	@GetMapping("/destination/{id}")
	Destination getDestinationById(@PathVariable Long id) {
		return destinationService.getDestinationById(id);
	}
	
	@PostMapping("/destination")
	Destination addDestination(@RequestBody Destination destination) {
		return destinationService.addDestination(destination);
	}
	
	@PostMapping("/destination/{id}")
	Destination addDestination(@RequestBody Destination destination,@PathVariable Long id) {
		destination.setId(id);
		destination.setUpdatedOn(new Date());
		return destinationService.addDestination(destination);
	}
	
	@GetMapping("/destination")
	List<Destination> getAllDestination(){
		return destinationService.getAllDestination();
	}
	
	@GetMapping("/destination/trip")
	List<Destination> getDestinationHavingTrips(){
		return destinationService.getDestinationHavingTrips();
	}
	

}
