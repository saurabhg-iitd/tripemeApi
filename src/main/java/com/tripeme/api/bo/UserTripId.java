package com.tripeme.api.bo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class UserTripId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1794888404759637193L;
	@ManyToOne
	User user;
	@ManyToOne
	Trip trip;
	
	public UserTripId(User user, Trip trip) {
		this.user = user;
		this.trip = trip;
	}
	
	public UserTripId() {
		
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTripId that = (UserTripId) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (trip != null ? !trip.equals(that.trip) : that.trip != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (trip != null ? trip.hashCode() : 0);
        return result;
    }
	
	
}
