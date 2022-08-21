package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Menu searchMenu(int MenuId) {
		String cmd = "select * from Menu where MenuId=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, new Object[] {MenuId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("MenuId"));
				menu.setRestaurantId(rs.getInt("RestaurantId"));
				menu.setItemName(rs.getString("ItemName"));
				menu.setMenuType(rs.getString("MenuType"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setPrice(rs.getInt("Price"));
				return menu;
			}
		});
		if (menuList.size()==1) {
			return menuList.get(0);
		}
		return null;
	}
	
	public List<Menu> showMenu(int RestaurantId) {
		String cmd = "select * from Menu where RestaurantId=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, new Object[] {RestaurantId},new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("MenuId"));
				menu.setRestaurantId(rs.getInt("RestaurantId"));
				menu.setItemName(rs.getString("ItemName"));
				menu.setMenuType(rs.getString("MenuType"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setPrice(rs.getInt("Price"));
				return menu;
			}
		});
		return menuList;
	}
	
	public Menu[] showMenu() {
		String cmd = "select * from Menu ";
		List<Menu> menuList = null;
		menuList= jdbcTemplate.query(cmd,  new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("MenuId"));
				menu.setRestaurantId(rs.getInt("RestaurantId"));
				menu.setItemName(rs.getString("ItemName"));
				menu.setMenuType(rs.getString("MenuType"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setPrice(rs.getInt("Price"));
				return menu;
			}
		});
		return menuList.toArray(new Menu[menuList.size()]);
	}

}
