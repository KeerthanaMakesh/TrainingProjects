package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Admin[] showAdmin() {
		String cmd = "select * from admin";
		List<Admin> adminList = null;
		adminList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminGender(rs.getString("adminGender"));
				admin.setAdminCity(rs.getString("adminCity"));
				admin.setAdminState(rs.getString("adminState"));
				admin.setAdminMob(rs.getString("adminMob"));
				admin.setAdminEmail(rs.getString("adminEmail"));
				return admin;
			}
		});
		return adminList.toArray(new Admin[adminList.size()]);
	}
	
	
	public Admin searchAdmin(int adminId)
	{
		String cmd = "select * from admin where adminId=?";
		List<Admin> adminList = jdbcTemplate.query(cmd, 
				new Object[] {adminId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admin admin = new Admin();
						admin.setAdminId(rs.getInt("adminId"));
						admin.setAdminName(rs.getString("adminName"));
						admin.setAdminGender(rs.getString("adminGender"));
						admin.setAdminCity(rs.getString("adminCity"));
						admin.setAdminState(rs.getString("adminState"));
						admin.setAdminMob(rs.getString("adminMob"));
						admin.setAdminEmail(rs.getString("adminEmail"));
						return admin;
					}
		});
		return adminList.get(0);
		
	}
	

}
