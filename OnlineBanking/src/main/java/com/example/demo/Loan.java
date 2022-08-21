package com.example.demo;

import java.util.Date;

public class Loan {
	
	private int loanId;
	 private int accountNumber;
	 private int loanAmount;
	 private Date loanApplyDate;
	 private String loanStatus;
	 private String loanApplyFor;
	
	 
	 public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Date getLoanApplyDate() {
		return loanApplyDate;
	}
	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLoanApplyFor() {
		return loanApplyFor;
	}
	public void setLoanApplyFor(String loanApplyFor) {
		this.loanApplyFor = loanApplyFor;
	}
	
	
	@Override
	public String toString() {
		return "LoanController [loanId=" + loanId + ", accountNumber=" + accountNumber + ", loanAmount=" + loanAmount
				+ ", loanApplyDate=" + loanApplyDate + ", loanStatus=" + loanStatus + ", loanApplyFor=" + loanApplyFor
				+ "]";
	}
	 

}
