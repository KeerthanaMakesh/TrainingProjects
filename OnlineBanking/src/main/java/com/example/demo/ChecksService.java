package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChecksService {
	
	@Autowired
	ChecksDAO dao;
	
	public Checks[] showChecks() {
		return dao.showChecks();
	}
	
	
	public Checks[] showChecksbyAccountNumber(int accountNumber) {
		return dao.showChecksbyAccountNumber(accountNumber);
	}
	
	public Checks searchChecks(int checkId)
	{
		return dao.searchChecks(checkId);
	}
	
	public String acceptOrRejectChecks(int checkId,String checkStatus) {
		return dao.acceptOrRejectChecks(checkId, checkStatus);
	}
	
	public String applyforCheck(Checks checks)
	{
		return dao.applyforCheck(checks);
	}

}
