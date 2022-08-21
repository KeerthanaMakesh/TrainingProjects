package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	

	@Autowired
	private MenuService menuService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showmenu")
	public Menu[] showMenu( ) {
		return menuService.showMenu();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showmenu/{RestaurantId}")
	public List<Menu> showMenu(@PathVariable int RestaurantId ) {
		return menuService.showMenu(RestaurantId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/searchmenu/{MenuId}")
	public Menu searchMenu(@PathVariable int MenuId) {
		return menuService.searchMenu(MenuId);
	}

}
