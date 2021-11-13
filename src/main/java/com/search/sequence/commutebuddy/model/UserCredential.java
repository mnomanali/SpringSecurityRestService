package com.search.sequence.commutebuddy.model;

import java.util.Date;

public class UserCredential {
	
	private String loginId;
	private String loginPassword;
	private long userId;
	private Date lastModified;
	private Date lastLogin;
	private Date loginCreated;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getLoginCreated() {
		return loginCreated;
	}
	public void setLoginCreated(Date loginCreated) {
		this.loginCreated = loginCreated;
	} 
	
	

}
