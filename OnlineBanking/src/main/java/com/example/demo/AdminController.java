package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping("/Admins")
	public Admin[] show() {
		return adminService.showAdmin();
	}
	
	
	@RequestMapping("/Admins/{adminId}")
	public Admin searchAdmin(@PathVariable int adminId) {
		return adminService.searchAdmin(adminId);
	}

}
