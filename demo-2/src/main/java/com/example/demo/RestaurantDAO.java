package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Restaurant searchRestaurant(int RestaurantId) {
		String cmd = "select * from Restaurant where RestaurantId=?";
		List<Restaurant> restaurantList = jdbcTemplate.query(cmd, new Object[] {RestaurantId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Restaurant res = new Restaurant();
				res.setRestaurantId(rs.getInt("RestaurantId"));
				res.setRestaurantName(rs.getString("RestaurantName"));
				res.setCity(rs.getString("City"));
				res.setBranch(rs.getString("Branch"));
				res.setEmail(rs.getString("Email"));
				res.setContactNo(rs.getString("ContactNo"));
				return res;
			}
		});
		if (restaurantList.size()==1) {
			return restaurantList.get(0);
		}
		return null;
	}

	public Restaurant[] showRestaurant() {
		String cmd = "select * from Restaurant";
		List<Restaurant> restaurantList = null;
		restaurantList = jdbcTemplate.query(cmd, new RowMapper() {
			 @Override
		        public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Restaurant res = new Restaurant();
		 
		            res.setRestaurantId(rs.getInt("RestaurantId"));
					res.setRestaurantName(rs.getString("RestaurantName"));
					res.setCity(rs.getString("City"));
					res.setBranch(rs.getString("Branch"));
					res.setEmail(rs.getString("Email"));
					res.setContactNo(rs.getString("ContactNo"));	
		            return res;
		        }
		 
		    });
		return restaurantList.toArray(new Restaurant[restaurantList.size()]);
	}

}
