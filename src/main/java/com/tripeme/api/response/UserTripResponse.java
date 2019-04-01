package com.tripeme.api.response;

import com.tripeme.api.enums.PaymentStatus;
import com.tripeme.api.enums.UserTripStatus;
import com.tripeme.api.bo.Trip;
import com.tripeme.api.bo.User;

public class UserTripResponse {
	User user;
	Trip trip;
	Integer myBookings;
	PaymentStatus paymentStatus;
	UserTripStatus userTripStatus;
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
	public Integer getMyBookings() {
		return myBookings;
	}
	public void setMyBookings(Integer myBookings) {
		this.myBookings = myBookings;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public UserTripStatus getUserTripStatus() {
		return userTripStatus;
	}
	public void setUserTripStatus(UserTripStatus userTripStatus) {
		this.userTripStatus = userTripStatus;
	}
	
	
}
