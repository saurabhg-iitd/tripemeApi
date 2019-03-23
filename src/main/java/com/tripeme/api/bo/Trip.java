package com.tripeme.api.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="trip")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long tripId;
	Date startDate;
	Date endDate;
	Integer maxBookings;
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
	@JoinColumn(name = "location_id", nullable = false)
	Location location;
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
	@JoinColumn(name = "theme_id", nullable = false)
	Theme theme;
	Date createdOn;
	Date updatedOn;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	@JsonBackReference
	private Set<UserTrip> userTrips = new HashSet<>(0);
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
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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
	public Set<UserTrip> getUserTrips() {
		return userTrips;
	}
	public void setUserTrips(Set<UserTrip> userTrips) {
		this.userTrips = userTrips;
	}
	
	

}
