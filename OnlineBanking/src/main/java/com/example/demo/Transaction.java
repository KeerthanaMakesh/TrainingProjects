package com.example.demo;

import java.util.Date;

public class Transaction {
	
	private int  tranId ;
	private int accountNumber;
	private int  tranAmount;
	private String tranType ;
	private Date  tranDate;
	
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", accountNumber=" + accountNumber + ", tranAmount=" + tranAmount
				+ ", tranType=" + tranType + ", tranDate=" + tranDate + "]";
	}

}
