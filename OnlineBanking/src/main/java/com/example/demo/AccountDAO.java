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
public class AccountDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Account[] showAccount() {
		String cmd = "select * from account";
		List<Account> accountList = null;
		accountList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				account.setAccountNumber(rs.getInt("accountNumber"));
				account.setFirstName(rs.getString("firstName"));
				account.setLastName(rs.getString("lastName"));
				account.setGender(rs.getString("gender"));
				account.setCity(rs.getString("city"));
				account.setState(rs.getString("state"));
				account.setMob(rs.getString("mob"));
				account.setEmail(rs.getString("email"));
				account.setBalance(rs.getInt("balance"));
				account.setCheqFacil(rs.getString("cheqFacil"));
				account.setAccountType(rs.getString("accountType"));
				account.setStatus (rs.getString("status"));
				account.setDateOfOpen(rs.getDate("dateOfOpen"));
				
				return account;
			}
		});
		return accountList.toArray(new Account[accountList.size()]);
	}
	
	public Account searchAccount(int accountNumber) {
		String cmd = "select * from account where accountNumber=?";
		List<Account> accountList = jdbcTemplate.query(cmd, 
				new Object[] {accountNumber}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Account account = new Account();
						account.setAccountNumber(rs.getInt("accountNumber"));
						account.setFirstName(rs.getString("firstName"));
						account.setLastName(rs.getString("lastName"));
						account.setGender(rs.getString("gender"));
						account.setCity(rs.getString("city"));
						account.setState(rs.getString("state"));
						account.setMob(rs.getString("mob"));
						account.setEmail(rs.getString("email"));
						account.setBalance(rs.getInt("balance"));
						account.setCheqFacil(rs.getString("cheqFacil"));
						account.setAccountType(rs.getString("accountType"));
						account.setStatus (rs.getString("status"));
						account.setDateOfOpen(rs.getDate("dateOfOpen"));
						return account;
					}
		});
		return accountList.get(0);
		
	}
	
	
	public String addAccount(Account account){
		int accountNumber = generateAccountNumber();
		account.setStatus("active");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		account.setDateOfOpen(dbDate);
		account.setAccountNumber(accountNumber);
		
		String cmd = "Insert into Account(accountNumber,firstName,lastName,gender,city,state,"
				+"mob,email,balance,cheqFacil,accountType,status,dateOfOpen)"
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {
				account.getAccountNumber(),
				account.getFirstName(),account.getLastName(),
				account.getGender(),
				account.getCity(),account.getState(),
				account.getMob(),account.getEmail(),
				account.getBalance(),
				account.getCheqFacil(),
				account.getAccountType(),
				account.getStatus(),
				account.getDateOfOpen()
		});
		
		return "Account Created";
	}
	
	public int generateAccountNumber() {
		String cmd="select case when max(accountNumber)is NULL THEN 1"
				+"else max(accountNumber)+1 end accno from Account";
		List<Object> accountNumber = jdbcTemplate.query(cmd, new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
				Object ob =rs.getInt("accountNumber");
				return ob;
			}
		});
		return (Integer)accountNumber.get(0);
	}
	
	public String deleteAccount(int accountNumber) {
		
		String cmd1 = "delete from transactions where accountNumber=?";
		jdbcTemplate.update(cmd1, new Object[] {accountNumber});
		String cmd = "delete from account where accountNumber=?";
		jdbcTemplate.update(cmd, new Object[] {accountNumber});
		return "Record Deleted...";
	}
	
	public String updateAccount(Account account) {
		String cmd = "Update account set firstName=?, lastName=?, "
				+ " gender=?, city=?, state=?,mob=?,email=?,balance=?,cheqFacil=?,accountType=?"
				+ "status=? where "
				+ " accountNumber=?";
		jdbcTemplate.update(cmd, new Object[] {
				account.getFirstName(), 
				account.getLastName(), 
				account.getGender(), 
				account.getCity(), 
				account.getState(), 
				account.getMob(),
				account.getEmail(),  
				account.getCheqFacil(), 
				account.getAccountType(), 
				account.getStatus(),
				account.getAccountNumber()

			});
		return "Record Updated...";
	}
	
	public Account showBalance(int accountNumber) {
		String cmd = "select balance from account where accountNumber=?";
		List<Account> accountList = jdbcTemplate.query(cmd, 
				new Object[] {accountNumber}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Account account = new Account();
//						account.setAccountNumber(rs.getInt("accountNumber"));
//						account.setFirstName(rs.getString("firstName"));
//						account.setLastName(rs.getString("lastName"));
//						account.setGender(rs.getString("gender"));
//						account.setCity(rs.getString("city"));
//						account.setState(rs.getString("state"));
//						account.setMob(rs.getString("mob"));
//						account.setEmail(rs.getString("email"));
						account.setBalance(rs.getInt("balance"));
//						account.setCheqFacil(rs.getString("cheqFacil"));
//						account.setAccountType(rs.getString("accountType"));
//						account.setStatus (rs.getString("status"));
//						account.setDateOfOpen(rs.getDate("dateOfOpen"));
						return account;
					}
		});
		return accountList.get(0);
		
	}

}
