package com.example.demo;

public class Admin {
	
	 private int adminId;
	 private String adminName;
	 private String adminGender;
	 private String adminCity;
	 private String adminState;
	 private String adminMob;
	 private String adminEmail;
	
	 public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminGender() {
		return adminGender;
	}
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}
	public String getAdminCity() {
		return adminCity;
	}
	public void setAdminCity(String adminCity) {
		this.adminCity = adminCity;
	}
	public String getAdminState() {
		return adminState;
	}
	public void setAdminState(String adminState) {
		this.adminState = adminState;
	}
	public String getAdminMob() {
		return adminMob;
	}
	public void setAdminMob(String adminMob) {
		this.adminMob = adminMob;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminGender=" + adminGender
				+ ", adminCity=" + adminCity + ", adminState=" + adminState + ", adminMob=" + adminMob + ", adminEmail="
				+ adminEmail + "]";
	}

}
