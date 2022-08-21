package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	AdminDAO dao;
	
	public Admin[] showAdmin() {
		return dao.showAdmin();
	}
	
	public Admin searchAdmin(int adminId) {
		return dao.searchAdmin(adminId);
	}

}
