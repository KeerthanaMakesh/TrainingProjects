package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping("/Accounts")
	public Account[] show() {
		return accountService.showAccount();
	}
	
	
	@RequestMapping("/Accounts/Customers/{accountNumber}")
	public Account searchAccount(@PathVariable int accountNumber) {
		return accountService.searchAccount(accountNumber);
	}
	
	
	@PostMapping("/Accounts/New")
	public String addAccount(@RequestBody Account account)  {
		return accountService.addAccount(account);
	}
	

//	@RequestMapping("/deleteAccount/{accountNumber}")
//	public String deleteAccount(@PathVariable int accountNumber) {
//		return accountService.deleteAccount(accountNumber);
//	}
	
	
	@PostMapping("/Accounts/Accounts")
	public String updateAccount(@RequestBody Account account) {
	return accountService.updateAccount(account);
	}
	
	
	@RequestMapping("/showBalance/{accountNumber}")
	public Account showBalance(@PathVariable int accountNumber) {
		return accountService.showBalance(accountNumber);
	}


}
