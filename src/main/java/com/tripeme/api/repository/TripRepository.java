package com.tripeme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
	/*Trip getTripByTripId(Long tripId);*/
	
	@Query(value = "SELECT * FROM trip t join destination d on d.id=t.destination_id WHERE l.name = ?1", nativeQuery = true)
	List<Trip> getTripsByDestinationName(String name);
	
	@Query(value = "SELECT * FROM trip t WHERE t.destination_id = ?1", nativeQuery = true)
	List<Trip> getTripsByDestinationId(Long id);

}
