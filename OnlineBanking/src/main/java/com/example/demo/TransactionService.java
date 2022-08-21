package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {
	
	 @Autowired
	    TransactionDAO dao;
	    
	 public Transaction[] showTransaction() {
    	 return dao.showTransaction();
     }
     
     public Transaction searchTransaction(int tranId) {
    	 return dao.searchTransaction(tranId);
     }
      
     public List<Transaction> searchbyaccno(int accountNumber) {
    	 return dao.searchbyaccno(accountNumber);
     }
     
     public List<Transaction> searchbydate(Date tranDate) {
    	 return dao.searchbydate(tranDate);
     }
     
     public String placeTransaction(Transaction transaction) {
    	 return dao.placeTransaction(transaction);
     }
     
     public String placeTransaction1(Transaction transaction) {
    	 return dao.placeTransaction1(transaction);
     }

}
