package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showrestaurant")
	public Restaurant[] show() {
		return restaurantService.showRestaurant();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/searchrestaurant/{RestaurantId}")
	public Restaurant searchRestaurant(@PathVariable int RestaurantId) {
		return restaurantService.searchRestaurant(RestaurantId);
	}

}