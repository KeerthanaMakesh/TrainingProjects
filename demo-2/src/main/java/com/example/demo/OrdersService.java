package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersService {
	
	@Autowired
	OrdersDAO dao;
	
	public Orders[] showCustomerOrders(int CCustomerId) {
		return dao.showCustomerOrders(CCustomerId);
	}
	
	public Orders[] showVendorOrders(int VendorId) {
		return dao.showVendorOrders(VendorId);
	}
	
	public Orders[] vendorPendingOrders(int VendorId) {
		return dao.vendorPendingOrders(VendorId);
	}
	
	public Orders[] customerPendingOrders(int CCustomerId) {
		return dao.customerPendingOrders(CCustomerId);
	}
	
	public Orders searchByOrderId(int OrderId) {
		return dao.searchOrder(OrderId);
	}
	
	public String placeOrder(Orders orders) {
		return dao.placeOrder(orders);
	}
	
	public String acceptOrRejectOrder(int OrderId, int VendorId, String status) {
		return dao.acceptOrRejectOrder(OrderId, VendorId, status);
	}

}
