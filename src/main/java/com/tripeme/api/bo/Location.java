package com.tripeme.api.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer locationId;
	String name;
	String city;
	String state;
	String country;
	double latitute;
	double logitute;
	Date cretedOn;
	Date updatedOn;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getLatitute() {
		return latitute;
	}
	public void setLatitute(double latitute) {
		this.latitute = latitute;
	}
	public double getLogitute() {
		return logitute;
	}
	public void setLogitute(double logitute) {
		this.logitute = logitute;
	}
	public Date getCretedOn() {
		return cretedOn;
	}
	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	
	
	
	
	

}
