package com.test.crm.service;

import java.util.List;

import com.test.crm.entity.Order;
import com.test.crm.entity.OrderDetails;

public interface OrderService {

	public List<Order> selectOrder(Integer cusId);
	public Order selectOrderById(Integer id);
	public float getTotalPrice(Integer orderId);
	public List<OrderDetails> getOrderDetails(Integer orderId);
	
}
