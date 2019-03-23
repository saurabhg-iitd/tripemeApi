package com.tripeme.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.UserTrip;
import com.tripeme.api.bo.UserTripId;

@Repository
public interface UserTripRepository extends JpaRepository<UserTrip, UserTripId>{
	

}
