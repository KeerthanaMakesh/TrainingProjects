package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Customer searchCustomer(int CCustomerId) {
		String cmd = "select * from Customer where CCustomerId=?";
		List<Customer> customerList = jdbcTemplate.query(cmd, new Object[] {CCustomerId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer cus = new Customer();
				cus.setCCustomerId(rs.getInt("CCustomerId"));
				cus.setCustomerName(rs.getString("CustomerName"));
				cus.setCity(rs.getString("City"));
				cus.setState(rs.getString("State"));
				cus.setEmail(rs.getString("Email"));
				cus.setContactNo(rs.getString("ContactNo"));
				return cus;
			}
		});
		if (customerList.size()==1) {
			return customerList.get(0);
		}
		return null;
	}
	
	
	public Customer[] showCustomer() {
		String cmd = "select * from Customer";
		List<Customer> customerList = null;
		customerList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer cus = new Customer();
				cus.setCCustomerId(rs.getInt("CCustomerId"));
				cus.setCustomerName(rs.getString("CustomerName"));
				cus.setCity(rs.getString("City"));
				cus.setState(rs.getString("State"));
				cus.setEmail(rs.getString("Email"));
				cus.setContactNo(rs.getString("ContactNo"));
				return cus;
			}
		});
		return customerList.toArray(new Customer[customerList.size()]);
	}

}
