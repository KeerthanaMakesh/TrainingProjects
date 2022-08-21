package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	
	@RequestMapping("/Loans")
	public Loan[] showLoan() {
		return loanService.showLoan();
		}
	
//	@CrossOrigin(origins="http://localhost:4200")
//	@RequestMapping("/showAllPendingLoan/{loanStatus}")
//	public Loan[] showAllPendingLoan(@PathVariable String loanStatus) {
//		return loanService.showAllPendingLoan(loanStatus);
//	}
	
	@RequestMapping("/Loans/{loanId}")
	public Loan searchLoan(@PathVariable int loanId) {
		return loanService.searchLoan(loanId);
		}
	
	@RequestMapping("/Loans/Customers/{accountNumber}")
	public Loan[] searchLoanByAccountNo(@PathVariable int accountNumber) {
		return loanService.searchLoanByAccountNo(accountNumber);
		}
	
	@RequestMapping("/Loans/Status/{loanStatus}")
	public Loan[] searchLoanByStatus(@PathVariable String loanStatus) {
		return loanService.searchLoanByStatus(loanStatus);
		}
	
	@PostMapping("/Loans/Loans/{loanId}/{loanStatus}")
	public String acceptOrRejectLoan(@PathVariable int loanId,
			@PathVariable String loanStatus) {
		return loanService.acceptOrRejectLoan(loanId, loanStatus);
		}
	
	@PostMapping("/Loans/New")
	public String addLoan(@RequestBody Loan loan) {
		return loanService.applyLoan(loan);
	}

	 

}
