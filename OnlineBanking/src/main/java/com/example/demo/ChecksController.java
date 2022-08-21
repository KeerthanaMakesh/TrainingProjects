package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChecksController {
	
	@Autowired
	private ChecksService checksService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/showChecks")
	public Checks[] showChecks() {
		return checksService.showChecks();
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/showChecksbyAccountNumber/{accountNumber}")
	public Checks[] showChecksbyAccountNumber(@PathVariable int accountNumber) {
		return checksService.showChecksbyAccountNumber(accountNumber);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/searchChecks/{checkId}")
	public Checks searchChecks(@PathVariable int checkId)
	{
		return checksService.searchChecks(checkId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/checks/applyforCheck")
	public String applyforCheck(@RequestBody Checks checks)
	{
		return checksService.applyforCheck(checks);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/acceptOrRejectChecks/{checkId}/{checkStatus}")
	public String acceptOrRejectChecks(@PathVariable int checkId,@PathVariable String checkStatus) {
		return checksService.acceptOrRejectChecks(checkId,checkStatus);
	}

}
