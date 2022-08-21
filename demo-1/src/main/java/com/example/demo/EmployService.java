package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployService {
	
	@Autowired
	EmployDAO dao;
	
	public Employ[] showEmploy() {
		return dao.showEmploy();
	}
	
	public Employ searchEmploy(int empno) {
		return dao.searchEmploy(empno);
	}

}
