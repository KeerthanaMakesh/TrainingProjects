package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {
	
	@Autowired
	private EmployService employService;
	
	@RequestMapping("/")
	public Employ[] show() {
		return employService.showEmploy();
	}
	
	@RequestMapping("/{empno}")
	public Employ searchEmploy(@PathVariable int empno) {
		return employService.searchEmploy(empno);
	}
	

}
