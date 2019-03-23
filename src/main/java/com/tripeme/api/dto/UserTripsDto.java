package com.tripeme.api.dto;

import java.util.List;

import com.tripeme.api.bo.Trip;
import com.tripeme.api.bo.User;

public class UserTripsDto {
	User user;
	List<Trip> trips;
}
