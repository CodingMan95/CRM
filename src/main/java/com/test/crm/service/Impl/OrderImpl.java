package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.OrderDao;
import com.test.crm.entity.Order;
import com.test.crm.entity.OrderDetails;
import com.test.crm.service.OrderService;

@Service
public class OrderImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Order> selectOrder(Integer cusId) {
		// TODO Auto-generated method stub
		return orderDao.selectOrder(cusId);
	}

	@Override
	public Order selectOrderById(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.selectOrderById(id);
	}

	@Override
	public float getTotalPrice(Integer orderId) {
		// TODO Auto-generated method stub
		return orderDao.getTotalPrice(orderId);
	}

	@Override
	public List<OrderDetails> getOrderDetails(Integer orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderDetails(orderId);
	}

}
