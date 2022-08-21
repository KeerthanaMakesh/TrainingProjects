package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showcustomer")
	public Customer[] show() {
		return customerService.showCustomer();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/searchcustomer/{CCustomerId}")
	public Customer searchCustomer(@PathVariable int CCustomerId)
	{
		return customerService.searchCustomer(CCustomerId);
	}

}
