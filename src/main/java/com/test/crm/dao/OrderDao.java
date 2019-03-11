package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.Order;
import com.test.crm.entity.OrderDetails;

public interface OrderDao {
	
	public List<Order> selectOrder(Integer cusId);
	public Order selectOrderById(Integer id);
	public float getTotalPrice(Integer orderId);
	public List<OrderDetails> getOrderDetails(Integer orderId);
	
}
