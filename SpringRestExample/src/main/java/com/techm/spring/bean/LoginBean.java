package com.techm.spring.bean;

import java.io.Serializable;

public class LoginBean implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private String userId;
	private String pwd;
	private boolean validUser;
	private String name;
	public boolean getValidUser() {
		return validUser;
	}
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
