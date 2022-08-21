package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Orders[] showCustomerOrders(int CCustomerId) {
		String cmd = "select * from Orders where CCustomerId=?";
		List<Orders> orderList = jdbcTemplate.query(cmd, new Object[] {CCustomerId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order = new Orders();
				order.setOrderId(rs.getInt("OrderId"));
				order.setMenuId(rs.getInt("MenuId"));
				order.setVendorId(rs.getInt("VendorId"));
				order.setCCustomerId(rs.getInt("CCustomerId"));
				order.setWalletId(rs.getInt("WalletId"));
				order.setBillAmount(rs.getInt("BillAmount"));
				order.setComments(rs.getString("Comments"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setOrderStatus(rs.getString("OrderStatus"));
				order.setQuantity(rs.getInt("Quantity"));
				return order;
			}
		});
		return orderList.toArray(new Orders[orderList.size()]);
	}
	
	public Orders[] customerPendingOrders(int CCustomerId) {
		String cmd = "select * from Orders where CCustomerId=? AND OrderStatus='PENDING' ";
		List<Orders> orderList = jdbcTemplate.query(cmd, new Object[] {CCustomerId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order = new Orders();
				order.setOrderId(rs.getInt("OrderId"));
				order.setMenuId(rs.getInt("MenuId"));
				order.setVendorId(rs.getInt("VendorId"));
				order.setCCustomerId(rs.getInt("CCustomerId"));
				order.setWalletId(rs.getInt("WalletId"));
				order.setBillAmount(rs.getInt("BillAmount"));
				order.setComments(rs.getString("Comments"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setOrderStatus(rs.getString("OrderStatus"));
				order.setQuantity(rs.getInt("Quantity"));
				return order;
			}
		});
		return orderList.toArray(new Orders[orderList.size()]);
	}
	
	
	public Orders[] showVendorOrders(int VendorId) {
		String cmd = "select * from Orders where VendorId=?";
		List<Orders> orderList = jdbcTemplate.query(cmd, new Object[] {VendorId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order = new Orders();
				order.setOrderId(rs.getInt("OrderId"));
				order.setMenuId(rs.getInt("MenuId"));
				order.setVendorId(rs.getInt("VendorId"));
				order.setCCustomerId(rs.getInt("CCustomerId"));
				order.setWalletId(rs.getInt("WalletId"));
				order.setBillAmount(rs.getInt("BillAmount"));
				order.setComments(rs.getString("Comments"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setOrderStatus(rs.getString("OrderStatus"));
				order.setQuantity(rs.getInt("Quantity"));
				return order;
			}
		});
		return orderList.toArray(new Orders[orderList.size()]);
	}
	
	public Orders[] vendorPendingOrders(int VendorId) {
		String cmd = "select * from Orders where VendorId=? AND OrderStatus='PENDING' ";
		List<Orders> orderList = jdbcTemplate.query(cmd, new Object[] {VendorId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order = new Orders();
				order.setOrderId(rs.getInt("OrderId"));
				order.setMenuId(rs.getInt("MenuId"));
				order.setVendorId(rs.getInt("VendorId"));
				order.setCCustomerId(rs.getInt("CCustomerId"));
				order.setWalletId(rs.getInt("WalletId"));
				order.setBillAmount(rs.getInt("BillAmount"));
				order.setComments(rs.getString("Comments"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setOrderStatus(rs.getString("OrderStatus"));
				order.setQuantity(rs.getInt("Quantity"));
				return order;
			}
		});
		return orderList.toArray(new Orders[orderList.size()]);
	}
	
	
	public Wallet searchByWalletId(int WalletId) {
		String cmd = "select * from Wallet where WalletId=?";
		List<Wallet> walletList = jdbcTemplate.query(cmd, 
				new Object[] {WalletId}, new RowMapper(){
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
	
	public Menu searchMenu(int MenuId)  {
		String cmd = "select * from Menu where MenuId=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, 
				new Object[] {MenuId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Menu menu = new Menu();
						menu.setMenuId(rs.getInt("MenuId"));
						menu.setRestaurantId(rs.getInt("RestaurantId"));
						menu.setItemName(rs.getString("ItemName"));
						menu.setMenuType(rs.getString("MenuType"));
						menu.setCalories(rs.getInt("Calories"));
						menu.setPrice(rs.getInt("Price"));
						return menu;
					}
		});
		return menuList.get(0);
	}


	
	public Orders searchOrder(int OrderId) {
		String cmd = "select * from Orders where OrderId=?";
		List<Orders> ordersList = jdbcTemplate.query(cmd, 
				new Object[] {OrderId},
				new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Orders	order = new Orders();
			    order.setOrderId(rs.getInt("OrderId"));
				order.setMenuId(rs.getInt("MenuId"));
				order.setVendorId(rs.getInt("VendorId"));
				order.setCCustomerId(rs.getInt("CCustomerId"));
				order.setWalletId(rs.getInt("WalletId"));
				order.setBillAmount(rs.getInt("BillAmount"));
				order.setComments(rs.getString("Comments"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setOrderStatus(rs.getString("OrderStatus"));
				order.setQuantity(rs.getInt("Quantity"));
				return order;
			}
		});
		return ordersList.get(0);
		
	}
	
	
	public String acceptOrRejectOrder(int OrderId, int VendorId, String status) {
		Orders order = searchOrder(OrderId);
		if (order.getVendorId()==VendorId) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update Orders set OrderStatus='ACCEPTED' "
						+ " WHERE OrderId=?";
				jdbcTemplate.update(cmd, new Object[] {OrderId});
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update Orders set OrderStatus='REJECTED' "
						+ " WHERE OrderId=?";
				jdbcTemplate.update(cmd,new Object[] {OrderId});
				cmd = "Update Wallet set WalletBalance=WalletBalance+? where WalletId=?";
				jdbcTemplate.update(cmd, new Object[] {order.getBillAmount(), order.getWalletId()});
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are unauthorized vendor...";
	}
	
	public String deductBalance(int WalletId, int BillAmount) {
		String cmd = "update Wallet set WalletBalance=WalletBalance-? where WalletId=?";
		jdbcTemplate.update(cmd, new Object[] {BillAmount,WalletId});
		return "Amount Deducted...";
	}
	
	public String placeOrder(Orders order)  {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = searchMenu(order.getMenuId());
		int price = menu.getPrice();
		int  billAmount = order.getQuantity() * price;
		Wallet wallet = searchByWalletId(order.getWalletId());
		int WalletBalance = wallet.getWalletBalance();
		if (WalletBalance - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(OrderId,VendorId,CCustomerId,MenuId,"
					+ "WalletId,OrderDate,Quantity,OrderStatus,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(cmd, new Object[] {
				order.getOrderId(), order.getVendorId(),
				order.getCCustomerId(),order.getMenuId(),
				order.getWalletId(), order.getOrderDate(),
				order.getQuantity(),order.getOrderStatus(),
				order.getBillAmount(),order.getComments()
			});
			deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId()  {
		String cmd = "select case when max(OrderId) is NULL THEN 1"
				+ " else max(OrderId)+1 end oid from Orders";
		List<Object> oid = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Object ob = rs.getInt("oid");
				return ob;
			}
		});
		return (Integer)oid.get(0);
	}
}
