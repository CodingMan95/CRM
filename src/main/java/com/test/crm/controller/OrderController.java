package com.test.crm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.Order;
import com.test.crm.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("order/list.do")
	@ResponseBody
	public List<Order> selectOrder(HttpServletRequest request, HttpServletResponse response) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Integer cusId = Integer.valueOf(request.getParameter("cusId"));

		List<Order> orders = orderService.selectOrder(cusId);

		for (int i = 0; i < orders.size(); i++) {

			Date orderTime = orders.get(i).getOrderDate();
			String oTime = dateFormat.format(orderTime);
			orders.get(i).setoTime(oTime);
		}

		return orders;

	}
	
	@RequestMapping("order/findById.do")
	@ResponseBody
	public Order selectOrderById(HttpServletRequest request, HttpServletResponse response) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Integer id = Integer.valueOf(request.getParameter("id"));

		Order order = orderService.selectOrderById(id);

		Date orderTime = order.getOrderDate();
		String oTime = dateFormat.format(orderTime);
		order.setoTime(oTime);
		
		return order;

	}
}
