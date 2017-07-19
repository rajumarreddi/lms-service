package com.techm.spring.bean;

import java.io.Serializable;
import java.util.Arrays;

public class RegistrationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String mobileNumber;
	private String email;
	private String password;
	private String gender;
	private String city;
	private String[] interests;
	private boolean registered;
	private boolean userExists;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	
	@Override
	public String toString() {
		return "RegistrationBean [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password="
				+ password + ", gender=" + gender + ", countrySelected=" + city + ", interests="
				+ Arrays.toString(interests) + ", registered=" + registered + "]";
	}
	public boolean isUserExists() {
		return userExists;
	}
	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}
	
	
}
