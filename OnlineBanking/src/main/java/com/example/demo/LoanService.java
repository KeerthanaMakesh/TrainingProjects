package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoanService {
	
	@Autowired
	LoanDAO dao;
	
	public Loan[] showLoan() {
		return dao.showLoan();
		}
	
//	public Loan[] showAllPendingLoan(String loanStatus) {
//		return dao.showAllPendingLoan(loanStatus);
//	}
	
	public Loan searchLoan(int loanId) {
		return dao.searchLoan(loanId);
		}
	
	public Loan[] searchLoanByAccountNo(int accountNumber) {
		return dao.searchLoanByAccountNo(accountNumber);
		}
	
	public Loan[] searchLoanByStatus(String loanStatus) {
		return dao.searchLoanByStatus(loanStatus);
		}
	
	public String acceptOrRejectLoan(int loanId,String loanStatus) {
		return dao.acceptOrRejectLoan(loanId, loanStatus);
	}
	
	public String applyLoan(Loan loan) {
		return dao.applyLoan(loan);
	}

}
