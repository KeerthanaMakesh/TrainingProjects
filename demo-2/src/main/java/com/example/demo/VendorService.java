package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendorService {
	
	@Autowired
	VendorDAO dao;
	
	public Vendor[] showVendor() {
		return dao.showVendor();
	}
	
	public Vendor searchVendor(int VendorId) {
		return dao.searchVendor(VendorId);
	}

}
