package com.tripeme.api.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tripeme.api.enums.PaymentStatus;

@Entity
@Table(name="payment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment {
	@Id
	String paymentId;
	String phone;
	String email;
	String buyerName;
	String amount;
	String currency;
	PaymentStatus paymentStatus;
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
	@JoinColumn(name = "user_id", nullable = false)
	User user;
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
	@JoinColumn(name = "trip_id", nullable = false)
	Trip trip;
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
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
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
}
