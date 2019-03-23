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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tripeme.api.enums.LoginType;

@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long userId;
	String emailId;
	String name;
	String imageUrl;
	String mobileNumber;
	Date createOn;
	Date updateOn;
	LoginType loginTpye;
	Long loginId;
	Boolean admin;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	private Set<UserTrip> userTrips = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
	private Set<UserSession> userSession = new HashSet<>();
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public Set<UserTrip> getUserTrips() {
		return userTrips;
	}
	public void setUserTrips(Set<UserTrip> userTrips) {
		this.userTrips = userTrips;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public LoginType getLoginTpye() {
		return loginTpye;
	}
	public void setLoginTpye(LoginType loginTpye) {
		this.loginTpye = loginTpye;
	}
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	
	
	
	
	
}
