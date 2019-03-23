package com.tripeme.api.request;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserTripRequest {
	Long userId;
	Long tripId;
	int totalBookings;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public int getTotalBookings() {
		return totalBookings;
	}
	public void setTotalBookings(int totalBookings) {
		this.totalBookings = totalBookings;
	}
	
	
	

}
