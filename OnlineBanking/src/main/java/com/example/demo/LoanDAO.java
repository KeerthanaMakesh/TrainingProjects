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
public class LoanDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Loan[] showLoan() {
		String cmd = "select * from loan";
		List<Loan> loanList = null;
		loanList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loanId"));
				loan.setAccountNumber(rs.getInt("accountNumber"));
				loan.setLoanAmount(rs.getInt("loanAmount"));
				loan.setLoanApplyDate(rs.getDate("loanApplyDate"));
				loan.setLoanStatus(rs.getString("loanStatus"));
				loan.setLoanApplyFor(rs.getString("loanApplyFor"));
				return loan;
			}
		});
	return loanList.toArray(new Loan[loanList.size()]);
}
//	public Loan[] showAllPendingLoan(String loanStatus) {
//		String cmd = "select * from loan where loanStatus=?";
//		List<Loan> loanList = jdbcTemplate.query(cmd,new Object[]{loanStatus}, new RowMapper() {
//
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Loan loan=new Loan();
//				loan.setLoanId(rs.getInt("loanId"));
//				loan.setAccountNumber(rs.getInt("accountNumber"));
//				loan.setLoanAmount(rs.getInt("loanAmount"));
//				loan.setLoanApplyDate(rs.getDate("loanApplyDate"));
//				loan.setLoanStatus(rs.getString("loanStatus"));
//				loan.setLoanApplyFor(rs.getString("loanApplyFor"));
//				return loan;
//			}
//		});
//	return loanList.toArray(new Loan[loanList.size()]);
//}
	
	public Loan searchLoan(int loanId) {
		String cmd = "select * from loan where loanId=?";
		List<Loan> loanList=jdbcTemplate.query(cmd, new Object[] {loanId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loanId"));
				loan.setAccountNumber(rs.getInt("accountNumber"));
				loan.setLoanAmount(rs.getInt("loanAmount"));
				loan.setLoanApplyDate(rs.getDate("loanApplyDate"));
				loan.setLoanStatus(rs.getString("loanStatus"));
				loan.setLoanApplyFor(rs.getString("loanApplyFor"));
				return loan;
			}
		});
		if (loanList.size()==1) {
			return loanList.get(0);
		}
		return null;
     }
	
	public Loan[] searchLoanByAccountNo(int accountNumber) {
		String cmd = "select * from loan where accountNumber=?";
		List<Loan> loanList=jdbcTemplate.query(cmd, new Object[] {accountNumber}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loanId"));
				loan.setAccountNumber(rs.getInt("accountNumber"));
				loan.setLoanAmount(rs.getInt("loanAmount"));
				loan.setLoanApplyDate(rs.getDate("loanApplyDate"));
				loan.setLoanStatus(rs.getString("loanStatus"));
				loan.setLoanApplyFor(rs.getString("loanApplyFor"));
				return loan;
			}
		});
	    return loanList.toArray(new Loan[loanList.size()]);
	   }
	
	public Loan[] searchLoanByStatus(String loanStatus) {
		String cmd = "select * from loan where loanStatus=?";
		List<Loan> loanList=jdbcTemplate.query(cmd,new Object[] {loanStatus}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loanId"));
				loan.setAccountNumber(rs.getInt("accountNumber"));
				loan.setLoanAmount(rs.getInt("loanAmount"));
				loan.setLoanApplyDate(rs.getDate("loanApplyDate"));
				loan.setLoanStatus(rs.getString("loanStatus"));
				loan.setLoanApplyFor(rs.getString("loanApplyFor"));
				return loan;
			}
		});
		return loanList.toArray(new Loan[loanList.size()]);
	}
	
	public String acceptOrRejectLoan(int loanId,String loanStatus) {
		Loan loan= searchLoan(loanId);
		//if(loan.getACCOUNTNUMBER()==ACCOUNTNUMBER) {
			if (loanStatus.toUpperCase().equals("YES")){
			String cmd= "update loan set loanStatus='approved'"
					+"where loanId=?";
			jdbcTemplate.update(cmd, new Object[] {loanId});
			return "Loan Approved Successfully...";
			}else {
				String cmd= "update loan set loanStatus='rejected'"
					+"where loanId=?";
				jdbcTemplate.update(cmd, new Object[] {loanId});
				cmd="update account set balance=balance+? where accountNumber=?";
				jdbcTemplate.update(cmd, new Object[] {loan.getLoanAmount(),loan.getAccountNumber()});
				return "loan rejected........";
				}
			}
	
	public String applyLoan(Loan loan)  {
		int lid = generateloanId();
		loan.setLoanStatus("pending");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		loan.setLoanApplyDate(dbDate);
		loan.setLoanId(lid);

		String cmd="insert into loan(loanId,accountNumber,loanAmount,loanApplyDate,loanStatus,loanApplyFor)"
				+"values(?,?,?,?,?,?)";
		jdbcTemplate.update(cmd,  new Object[] {
				loan.getLoanId(),loan.getAccountNumber(),
				loan.getLoanAmount(),loan.getLoanApplyDate(),
				loan.getLoanStatus(),loan.getLoanApplyFor()
				});
		return "loan applied successfully";
	}
	
	public int generateloanId()  {
		String cmd = "select case when max(loanId) is NULL THEN 1"
			+ " else max(loanId)+1 end lid from loan";
		List<Object> lid = jdbcTemplate.query(cmd, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Object ob = rs.getInt("lid");
				return ob;
				}
			});
		return (Integer)lid.get(0);
		}
	}
