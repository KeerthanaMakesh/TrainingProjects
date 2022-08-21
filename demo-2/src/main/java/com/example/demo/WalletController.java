package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showwallet")
	public Wallet[] show() {
		return walletService.showWallet();
	}
	
    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/searchwallet/{CustomerId}")
	public Wallet[] searchWallet(@PathVariable int CustomerId) {
		return walletService.searchWallet(CustomerId);
	}
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/searchbywalletid/{WalletId}")
	public Wallet searchByWalletId(@PathVariable int WalletId) {
		return walletService.searchByWalletId(WalletId);
	}

}
