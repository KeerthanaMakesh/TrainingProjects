package com.example.demo;

import java.util.Date;

public class Account {
	
	private int accountNumber;
	private String firstName;
	private String lastName;
	private String gender;
	private String city;
	private String state;
	private String mob;
	private String email;
	private int balance;
	private String cheqFacil;
	private String accountType;
	private String status;
	private Date dateOfOpen;
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCheqFacil() {
		return cheqFacil;
	}
	public void setCheqFacil(String cheqFacil) {
		this.cheqFacil = cheqFacil;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfOpen() {
		return dateOfOpen;
	}
	public void setDateOfOpen(Date dateOfOpen) {
		this.dateOfOpen = dateOfOpen;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", mob=" + mob + ", email=" + email
				+ ", balance=" + balance + ", cheqFacil=" + cheqFacil + ", accountType=" + accountType + ", status="
				+ status + ", dateOfOpen=" + dateOfOpen + "]";
	}
	
	
	
	
	
}