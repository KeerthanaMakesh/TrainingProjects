package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 public Transaction [] showTransaction() {
			String cmd = "select * from Transactions";
			List<Transaction> transactionList = null;
			transactionList = jdbcTemplate.query(cmd,new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{	
			Transaction transaction = new Transaction();
			 transaction.setTranId(rs.getInt("tranId"));
			 transaction.setAccountNumber(rs.getInt("accountNumber"));
			 transaction.setTranAmount(rs.getInt("tranAmount"));
			 transaction.setTranType(rs.getString("tranType"));
			 transaction.setTranDate(rs.getDate("tranDate"));
			 return transaction;
			 }
			});
		return transactionList.toArray(new Transaction[transactionList.size()]);	 
			}
	 
	 public Transaction searchTransaction(int tranId) {
			String cmd = "select * from Transactions where tranId=?";	
			List<Transaction> transactionList = jdbcTemplate.query(cmd, new Object [] {tranId}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Transaction transaction = new Transaction();
				 transaction.setTranId(rs.getInt("tranId"));
				 transaction.setAccountNumber(rs.getInt("accountNumber"));
				 transaction.setTranAmount(rs.getInt("tranAmount"));
				 transaction.setTranType(rs.getString("tranType"));
				 transaction.setTranDate(rs.getDate("tranDate"));
				 return transaction;	
		}
			});
			if(transactionList.size()==1) {
				return transactionList.get(0);
			}
			return null;
			}	
	 
	 public List<Transaction> searchbyaccno(int accountNumber) {
			String cmd = "select * from Transactions where accountNumber=?";	
			List<Transaction> transactionList = jdbcTemplate.query(cmd, new Object [] {accountNumber}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Transaction transaction = new Transaction();
				 transaction.setTranId(rs.getInt("tranId"));
				 transaction.setAccountNumber(rs.getInt("accountNumber"));
				 transaction.setTranAmount(rs.getInt("tranAmount"));
				 transaction.setTranType(rs.getString("tranType"));
				 transaction.setTranDate(rs.getDate("tranDate"));
				 return transaction;	
		}
			});
			return transactionList;
			}	 
	 public List<Transaction> searchbydate(Date tranDate) {
			String cmd = "select * from Transactions where tranDate=?";	
			List<Transaction> transactionList = jdbcTemplate.query(cmd, new Object [] {tranDate}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Transaction transaction = new Transaction();
				 transaction.setTranId(rs.getInt("tranId"));
				 transaction.setAccountNumber(rs.getInt("accountNumber"));
				 transaction.setTranAmount(rs.getInt("tranAmount"));
				 transaction.setTranType(rs.getString("tranType"));
				 transaction.setTranDate(rs.getDate("tranDate"));
				 return transaction;	
		}
			});
			return transactionList;
			}	
	 
	 
	 
	 public String deductBalance(int tranAmount,int accountNumber) {
			String cmd = "update account set balance=balance-? where accountNumber=?";
			jdbcTemplate.update(cmd, new Object[] {tranAmount,accountNumber});
			return "Amount Deducted...";
		} 
	 
      public String placeTransaction(Transaction transaction) {
    	 int tranId = generatetranId();
		 java.util.Date today = new Date();
		 java.sql.Date dbDate = new java.sql.Date(today.getTime());
//		 transaction.setTranDate(dbDate);
//		 int tranAmount = 0;
//		 Account account = (Account) searchbyaccno(transaction.getAccountNumber());
//		 int balance = account.getBalance();
//		 if(balance-tranAmount > 0) {
//			 transaction.setTranAmount(tranAmount);
			 transaction.setTranId(tranId);
			 String cmd="insert into Transactions(tranId,accountNumber,tranAmount,tranType,tranDate)"
					 +"values(?,?,?,?,?)";
			 jdbcTemplate.update(cmd, new Object[] {
					 transaction.getTranId(),
					 transaction.getAccountNumber(),
					 transaction.getTranAmount(),
					 transaction.getTranType(),
					 transaction.getTranDate()
			 });
			 deductBalance(transaction.getAccountNumber(),transaction.getTranAmount());
			 return " Transfered Successfully";
				 
		 }
		 
//		return "Insufficient Balance"; 
// }
//      
      public String addBalance(int tranAmount,int accountNumber) {
			String cmd = "update account set balance=balance+? where accountNumber=?";
			jdbcTemplate.update(cmd, new Object[] {tranAmount,accountNumber});
			return "Amount added...";
			
		} 
      
      public String placeTransaction1(Transaction transaction) {
			int tranId = generatetranId();
			java.util.Date today = new Date();
			java.sql.Date dbDate = new java.sql.Date(today.getTime());
			transaction.setTranDate(dbDate);
			//loan.setLoanId(lid);
			transaction.setTranId(tranId);
			String cmd = "insert into transactions(tranId,accountNumber,tranAmount,tranType,tranDate)" + " values(?,?,?,?,?)";
			jdbcTemplate.update(cmd, new Object[] {
				transaction.getTranId(),
				transaction.getAccountNumber(),
				transaction.getTranAmount(),
				transaction.getTranType(),
				transaction.getTranDate(),
			});
			addBalance(transaction.getTranAmount(),transaction.getAccountNumber() );
			
			return "transaction Successful...";
			
		}
      
      
	public int generatetranId() {
		String cmd="select case when max(tranId)is NULL THEN 1"
				+"else max(tranId)+1 end tranId from transactions";
		List<Object> tranId = jdbcTemplate.query(cmd, new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs,int rowNum)throws SQLException{
				Object ob = rs.getInt("tranId");
				return ob;
			}
		});
		return (Integer)tranId.get(0);
	}

}
