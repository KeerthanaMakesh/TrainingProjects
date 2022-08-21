package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	AccountDAO dao;
	
	public Account[] showAccount() {
		return dao.showAccount();
	}
	
	public Account searchAccount(int accountNumber) {
		return dao.searchAccount(accountNumber);
	}
	
	public String addAccount(Account account)  
	{
		return dao.addAccount(account);
	}
	
	public String deleteAccount(int accountNumber) {
		return dao.deleteAccount(accountNumber);
	}
	
	public String updateAccount(Account account) {
		return dao.updateAccount(account);
	}
	
	public Account showBalance(int accountNumber) {
		return dao.showBalance(accountNumber);
	}

}
