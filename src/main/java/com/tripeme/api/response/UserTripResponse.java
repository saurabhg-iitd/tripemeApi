package com.tripeme.api.response;

import com.tripeme.api.enums.PaymentStatus;
import com.tripeme.api.bo.Trip;
import com.tripeme.api.bo.User;

public class UserTripResponse {
	User user;
	Trip trip;
	Integer numPeople;
	PaymentStatus paymentStatus;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Integer getNumPeople() {
		return numPeople;
	}
	public void setNumPeople(Integer numPeople) {
		this.numPeople = numPeople;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
