package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Employ searchEmploy(int empno) {
		String cmd = "select * from EmployNew where empno=?";
		List<Employ> employList = jdbcTemplate.query(cmd, new Object[] {empno}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employ employ = new Employ();
				employ.setEmpno(rs.getInt("empno"));
				employ.setName(rs.getString("name"));
				employ.setGender(rs.getString("gender"));
				employ.setDept(rs.getString("dept"));
				employ.setDesig(rs.getString("desig"));
				employ.setBasic(rs.getInt("basic"));
				return employ;
			}
		});
		if (employList.size()==1) {
			return employList.get(0);
		}
		return null;
	}

	public Employ[] showEmploy() {
		String cmd = "select * from EmployNew";
		List<Employ> employList = null;
		employList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employ employ = new Employ();
				employ.setEmpno(rs.getInt("empno"));
				employ.setName(rs.getString("name"));
				employ.setGender(rs.getString("gender"));
				employ.setDept(rs.getString("dept"));
				employ.setDesig(rs.getString("desig"));
				employ.setBasic(rs.getInt("basic"));
				return employ;
			}
		});
		return employList.toArray(new Employ[employList.size()]);
	}
}
