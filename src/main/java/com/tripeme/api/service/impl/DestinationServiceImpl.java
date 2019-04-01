package com.tripeme.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.Destination;
import com.tripeme.api.repository.DesinationRepository;
import com.tripeme.api.service.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService{
	@Autowired
	DesinationRepository desinationRepository;

	@Override
	public Destination addDestination(Destination destination) {

		return 	desinationRepository.save(destination);
	}

	@Override
	public Destination getDestinationByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> getAllDestination() {
		// TODO Auto-generated method stub
		return desinationRepository.findAll();
	}

	@Override
	public Destination getDestinationById(Long destinationId) {
		// TODO Auto-generated method stub
		return desinationRepository.getOne(destinationId);
	}
	
	public List<Destination> getDestinationHavingTrips(){
		return desinationRepository.getDestinationsHavingTrips();
	}

}
