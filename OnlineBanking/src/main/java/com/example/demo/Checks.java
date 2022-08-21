package com.example.demo;

import java.util.Date;

public class Checks {
	
	 private int checkId;
	 private int accountNumber;
	 private int checkAmount;
	 private Date checkApplyDate;
	 private String checkStatus;
	
	 public int getCheckId() {
		return checkId;
	}
	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getCheckAmount() {
		return checkAmount;
	}
	public void setCheckAmount(int checkAmount) {
		this.checkAmount = checkAmount;
	}
	public Date getCheckApplyDate() {
		return checkApplyDate;
	}
	public void setCheckApplyDate(Date checkApplyDate) {
		this.checkApplyDate = checkApplyDate;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	
	@Override
	public String toString() {
		return "Checks [checkId=" + checkId + ", accountNumber=" + accountNumber + ", checkAmount=" + checkAmount
				+ ", checkApplyDate=" + checkApplyDate + ", checkStatus=" + checkStatus + "]";
	}
	
	 
	

}
