package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService {
	
	@Autowired
	MenuDAO dao;

	public Menu[] showMenu() {
		return dao.showMenu();
	}
	
	public List<Menu> showMenu(int RestaurantId) {
		return dao.showMenu(RestaurantId);
	}
	
	public Menu searchMenu(int MenuId) {
		return dao.searchMenu(MenuId);
	}
}


