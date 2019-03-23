package com.tripeme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
	Trip getTripByTripId(Long tripId);
	
	@Query(value = "SELECT * FROM trip t join location l on l.location_id=t.location_id WHERE l.name = ?1", nativeQuery = true)
	List<Trip> getTripsByLocationName(String name);
	
	@Query(value = "SELECT * FROM trip t WHERE t.location_id = ?1", nativeQuery = true)
	List<Trip> getTripsByLocationId(Integer id);

}
