package com.tripeme.api.request;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.tripeme.api.bo.Destination;
import com.tripeme.api.bo.Theme;

public class TripRequest {
	Long tripId;
	Date startDate;
	Date endDate;
	Integer maxBookings;
	Destination destination;
	Theme theme;
	MultipartFile[] files;
	/*Integer locationId;
	Integer themeId;*/
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
	
	
	
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
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
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	
	
	
}
