package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	public Vendor searchVendor(int VendorId) {
		String cmd = "select * from Vendor where VendorId=?";
		List<Vendor> vendorList = jdbcTemplate.query(cmd, new Object[] {VendorId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor v = new Vendor();
				v.setVendorId(rs.getInt("VendorId"));
				v.setVendorName(rs.getString("VendorName"));
				v.setVendorCity(rs.getString("VendorCity"));
				v.setVendorState(rs.getString("VendorState"));
				v.setVendorEmail(rs.getString("VendorEmail"));
				v.setVendorContactNo(rs.getString("VendorContactNo"));
				return v;
			}
		});
		if (vendorList.size()==1) {
			return vendorList.get(0);
		}
		return null;
	}

	public Vendor[] showVendor() {
		String cmd = "select * from Vendor";
		List<Vendor> vendorList = null;
		vendorList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor v = new Vendor();
				v.setVendorId(rs.getInt("VendorId"));
				v.setVendorName(rs.getString("VendorName"));
				v.setVendorCity(rs.getString("VendorCity"));
				v.setVendorState(rs.getString("VendorState"));
				v.setVendorEmail(rs.getString("VendorEmail"));
				v.setVendorContactNo(rs.getString("VendorContactNo"));
				return v;
			}
		});
		return vendorList.toArray(new Vendor[vendorList.size()]);
	}

}
