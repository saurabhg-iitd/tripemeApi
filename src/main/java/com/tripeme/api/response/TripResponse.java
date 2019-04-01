package com.tripeme.api.response;

import java.util.Date;
import java.util.List;

import com.tripeme.api.bo.Resource;
import com.tripeme.api.bo.Destination;
import com.tripeme.api.bo.Theme;

public class TripResponse {
	
	Long tripId;
	String name;
	String description;
	
	Date startDate;
	Date endDate;
	Integer maxBookings;
	Destination destination;
	Theme theme;
	Date createdOn;
	Date updatedOn;
	List<Resource>resources;
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
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
	public List<Resource> getImages() {
		return resources;
	}
	public void setImages(List<Resource> resources) {
		this.resources = resources;
	}
	
	

}
