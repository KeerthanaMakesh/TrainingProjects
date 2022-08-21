package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showvendor")
	public Vendor[] show() {
		return vendorService.showVendor();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/searchvendor/{VendorId}")
	public Vendor searchVendor(@PathVariable int VendorId) {
		return vendorService.searchVendor(VendorId);
	}

}
