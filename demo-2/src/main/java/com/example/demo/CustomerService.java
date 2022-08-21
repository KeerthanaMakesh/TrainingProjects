package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerDAO dao;
	
	public Customer[] showCustomer() {
		return dao.showCustomer();
	}
	
	public Customer searchCustomer(int CCustomerId)
	{
		return dao.searchCustomer(CCustomerId);
	}
	
	

}
