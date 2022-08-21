package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransactionController {
	
	 @Autowired
	    private TransactionService transactionservice;
	 
	 
	 @RequestMapping("/Transactions")
	   public Transaction[] show() {
		   return transactionservice.showTransaction();
	   }
	   
	 
	 @RequestMapping("/Transactions/{tranId}")
	   public Transaction searchTransaction(@PathVariable int tranId){
		   return transactionservice.searchTransaction(tranId);
	   }
	 
	
	 @RequestMapping("/Transactions/Customer/{accountNumber}")
	   public List<Transaction> searchbyaccno(@PathVariable int accountNumber){
		   return transactionservice.searchbyaccno(accountNumber);
	   }
	 
//	 @RequestMapping("/searchbydate/{tranDate}")
//	   public List<Transaction> searchbydate(@PathVariable Date tranDate){
//		   return transactionservice.searchbydate(tranDate);
//	   }
	 
	
	 @PostMapping("/Transactions/New")
	 public String add(@RequestBody Transaction transaction) {
		 return transactionservice.placeTransaction(transaction);
	 }
	 
	 
	 @PostMapping("/Transactions/Transactions")
	 public String add1(@RequestBody Transaction transaction) {
		 return transactionservice.placeTransaction1(transaction);
	 }
	    

}
