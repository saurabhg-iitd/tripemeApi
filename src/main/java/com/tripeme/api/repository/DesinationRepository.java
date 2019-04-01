package com.tripeme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Destination;

@Repository
public interface DesinationRepository extends JpaRepository<Destination, Long> {
	
	@Query(value="select d.* from destination d right join trip t on t.destination_id=d.id group by d.id;", nativeQuery=true)
	List<Destination> getDestinationsHavingTrips();

}
