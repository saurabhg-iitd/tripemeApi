package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.bo.Destination;

public interface DestinationService {
	Destination addDestination(Destination destination);
	Destination getDestinationByName(String name);
	Destination getDestinationById(Long id);
	List<Destination> getDestinationHavingTrips();
	List<Destination> getAllDestination();

}
