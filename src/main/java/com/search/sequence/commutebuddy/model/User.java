package com.search.sequence.commutebuddy.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String province;
	private String city;
	private String telephone1;
	private String telephone2;
	private String gender;
	private Date accountCreated;
	private Date accountUpdated;
	private String email; 
	private boolean sendOffers;
	private int userRating;
	
	public Map<String, Object> toMap() {
		  Map<String, Object> values = new HashMap<>();
		  values.put("firstName", firstName);
		  values.put("lastName", lastName);
		  values.put("address1", address1);
		  values.put("address1", address2);
		  values.put("address1", province);
		  values.put("address1", city);
		  values.put("telephone1", telephone1);
		  values.put("telephone2", telephone2);
		  values.put("gender", gender);
		  values.put("accountCreated", accountCreated);
		  values.put("accountUpdated", accountUpdated);
		  values.put("email", email);
		  values.put("sendOffers", sendOffers);
		  values.put("userRating", userRating);
		  return values;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getAccountCreated() {
		return accountCreated;
	}
	public void setAccountCreated(Date accountCreated) {
		this.accountCreated = accountCreated;
	}
	public Date getAccountUpdated() {
		return accountUpdated;
	}
	public void setAccountUpdated(Date accountUpdated) {
		this.accountUpdated = accountUpdated;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSendOffers() {
		return sendOffers;
	}
	public void setSendOffers(boolean sendOffers) {
		this.sendOffers = sendOffers;
	}
	public int getUserRating() {
		return userRating;
	}
	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

}
