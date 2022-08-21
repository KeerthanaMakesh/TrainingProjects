package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showcustomerorders/{CCustomerId}")
	public Orders[] showCustomerOrders(@PathVariable int CCustomerId) {
		return ordersService.showCustomerOrders(CCustomerId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/showvendororders/{VendorId}")
	public Orders[] showVendorOrders(@PathVariable int VendorId) {
		return ordersService.showVendorOrders(VendorId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/vendorpendingorders/{VendorId}")
	public Orders[] vendorPendingOrders(@PathVariable int VendorId)
	{
		return ordersService.vendorPendingOrders(VendorId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/customerpendingorders/{CCustomerId}")
	public Orders[] customerPendingOrders(@PathVariable int CCustomerId)
	{
		return ordersService.customerPendingOrders(CCustomerId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/OrderSearch/{OrderId}")
	public Orders orderSearch(@PathVariable int OrderId) {
		return ordersService.searchByOrderId(OrderId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/acceptOrRejectOrder/{OrderId}/{VendorId}/{status}")
	public String acceptOrReject(@PathVariable int OrderId,@PathVariable int VendorId,
	@PathVariable String status) {
	return ordersService.acceptOrRejectOrder(OrderId, VendorId, status);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/orders/placeOrder")
	public String add(@RequestBody Orders orders) {
	return ordersService.placeOrder(orders);
	}

}
