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
public class ChecksDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Checks[] showChecks() {
		String cmd= "select * from Checks";
		List<Checks> checkList = null;
		checkList = jdbcTemplate.query(cmd,new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Checks c = new Checks();
				c.setCheckId(rs.getInt("checkId"));
				c.setAccountNumber(rs.getInt("accountNumber"));
				c.setCheckAmount(rs.getInt("checkAmount"));
				c.setCheckApplyDate(rs.getDate("checkApplyDate"));
				c.setCheckStatus(rs.getString("checkStatus"));
				return c;
			}
		});
		return checkList.toArray(new Checks[checkList.size()]);
	}
	
	
	public Checks[] showChecksbyAccountNumber(int accountNumber) {
		String cmd= "select * from Checks where accountNumber=?";
		List<Checks> checkList = jdbcTemplate.query(cmd,new Object[]{accountNumber},new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Checks c = new Checks();
				c.setCheckId(rs.getInt("checkId"));
				c.setAccountNumber(rs.getInt("accountNumber"));
				c.setCheckAmount(rs.getInt("checkAmount"));
				c.setCheckApplyDate(rs.getDate("checkApplyDate"));
				c.setCheckStatus(rs.getString("checkStatus"));
				return c;
			}
		});
		return checkList.toArray(new Checks[checkList.size()]);
	}
	
	public Checks searchChecks(int checkId) {
		String cmd="select * from Checks where checkId=?";
		List<Checks>checkList = jdbcTemplate.query(cmd,
				new Object[] {checkId},
				new RowMapper() {

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Checks c = new Checks();
						c.setCheckId(rs.getInt("checkId"));
						c.setAccountNumber(rs.getInt("accountNumber"));
						c.setCheckAmount(rs.getInt("checkAmount"));
						c.setCheckApplyDate(rs.getDate("checkApplyDate"));
						c.setCheckStatus(rs.getString("checkStatus"));
						return c;
					}
		});
		return checkList.get(0);
	}
	
	public String applyforCheck(Checks checks) {
		int checkId =generateCheckId();
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		checks.setCheckApplyDate(dbDate);
		String cmd="insert into checks(checkId,accountNumber,checkAmount,checkApplyDate,checkStatus)"
				+" values(?,?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {
				checks.getCheckId(),checks.getAccountNumber(),
				checks.getCheckAmount(),checks.getCheckApplyDate(),
				checks.getCheckStatus()
				
		});
		return "Check Applied";
	}
	
	public int generateCheckId()
	{
		String cmd="select case when max(checkId) is NULL THEN 1"
				+"else max(checkId)+1 end checkId from checks";
		List<Object> checkId=jdbcTemplate.query(cmd, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs,int rowNum)throws SQLException{
				Object ob = rs.getInt("checkId");
				return ob;
			}
		});
		return(Integer)checkId.get(0);
	}
	
	public String acceptOrRejectChecks(int checkId,String checkStatus) {
		Checks check=searchChecks(checkId);
		if(checkStatus.toUpperCase().contentEquals("YES")) {
			String cmd="update checks set checkStatus='approved'"
					+"where checkId=?";
			jdbcTemplate.update(cmd,new Object[] {checkId});
			return "Check Approved...";	 
		}
		else {
			String cmd="update checks set checkStatus='rejected'"
					+"where checkId=?";
			jdbcTemplate.update(cmd,new Object[] {checkId});
			cmd="update account set balance=balance +? where accountNumber=?" ;
			   jdbcTemplate.update(cmd,new Object[] {check.getCheckAmount(),check.getAccountNumber()});
			return "Check Bounced";
		}	
	}
	


}
