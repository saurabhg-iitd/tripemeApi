package com.tripeme.api.request;

import java.util.Date;

public class TripRequest {
	Long tripId;
	Date startDate;
	Date endDate;
	Integer maxBookings;
	Integer locationId;
	Integer themeId;
	Date createdOn;
	Date updatedOn;
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getMaxBookings() {
		return maxBookings;
	}
	public void setMaxBookings(Integer maxBookings) {
		this.maxBookings = maxBookings;
	}
	
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
}
