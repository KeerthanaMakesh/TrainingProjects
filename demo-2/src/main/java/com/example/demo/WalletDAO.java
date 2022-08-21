package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WalletDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	public Wallet[] searchWallet(int CustomerId) {
		String cmd = "select * from Wallet where CustomerId=?";
		List<Wallet> walletList = jdbcTemplate.query(cmd, new Object[] {CustomerId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wallet w = new Wallet();
				w.setCustomerId(rs.getInt("CustomerId"));
				w.setWalletId(rs.getInt("WalletId"));
				w.setWalletName(rs.getString("WalletName"));
				w.setWalletBalance(rs.getInt("WalletBalance"));
				return w;
			}
		});
		return walletList.toArray(new Wallet[walletList.size()]);
	}

	public Wallet[] showWallet() {
		String cmd = "select * from Wallet";
		List<Wallet> walletList = null;
		walletList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wallet w = new Wallet();
				w.setCustomerId(rs.getInt("CustomerId"));
				w.setWalletId(rs.getInt("WalletId"));
				w.setWalletName(rs.getString("WalletName"));
				w.setWalletBalance(rs.getInt("WalletBalance"));
				return w;
			}
		});
		return walletList.toArray(new Wallet[walletList.size()]);
	}
	
	public String deductBalance(int WalletId, int billAmount) {
		String cmd = "update Wallet set WalletBalance=WalletBalance-? where WalletId=?";
		jdbcTemplate.update(cmd, new Object[] {billAmount,WalletId});
		return "Amount Deducted...";
	}
	
	public Wallet searchByWalletId(int WalletId) {
		String cmd = "select * from Wallet where WalletId=?";
		List<Wallet> walletList = jdbcTemplate.query(cmd, new Object[] {WalletId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Wallet wallet = new Wallet();
						wallet.setWalletId(rs.getInt("WalletId"));
						wallet.setCustomerId(rs.getInt("CustomerId"));
						wallet.setWalletName(rs.getString("WalletName"));
						wallet.setWalletBalance(rs.getInt("WalletBalance"));
						return wallet;
					}
		});
		return walletList.get(0);
		
	}

}
