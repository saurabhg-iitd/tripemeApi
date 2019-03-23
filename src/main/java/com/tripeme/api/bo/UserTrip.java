package com.tripeme.api.bo;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tripeme.api.enums.UserTripStatus;


@Entity
@AssociationOverrides({
	@AssociationOverride(name = "pk.user", 
		joinColumns = @JoinColumn(name = "userId")),
	@AssociationOverride(name = "pk.trip", 
		joinColumns = @JoinColumn(name = "tripId")) })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserTrip {
	private UserTripId pk = new UserTripId();
	private Date createOn;
	/*@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
	@JoinColumn(name = "payment_id", nullable = false)
	Payment payment;*/
	@NotNull
	UserTripStatus userTripStatus;
	@NotNull
	private int totalBookings;
	
	@EmbeddedId
	public UserTripId getPk() {
		return pk;
	}
	public void setPk(UserTripId pk) {
		this.pk = pk;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public int getTotalBookings() {
		return totalBookings;
	}
	public void setTotalBookings(int totalBookings) {
		this.totalBookings = totalBookings;
	}
	
	
	/*public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}*/
	
	@Transient
	public User getUser() {
		return getPk().getUser();
	}

	
	public UserTripStatus getUserTripStatus() {
		return userTripStatus;
	}
	public void setUserTripStatus(UserTripStatus userTripStatus) {
		this.userTripStatus = userTripStatus;
	}
	public void setUser(User user) {
		getPk().setUser(user);
	}

	@Transient
	public Trip getTrip() {
		return getPk().getTrip();
	}

	public void setTrip(Trip trip) {
		getPk().setTrip(trip);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserTrip that = (UserTrip) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	

}
