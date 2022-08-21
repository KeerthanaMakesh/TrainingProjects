package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WalletService {
	
	@Autowired
	WalletDAO dao;
	
	public Wallet[] showWallet() {
		return dao.showWallet();
	}
	
	public Wallet[] searchWallet(int CustomerId) {
		return dao.searchWallet(CustomerId);
	}
	
	public Wallet searchByWalletId(int WalletId) {
		return dao.searchByWalletId(WalletId);
	}

}
