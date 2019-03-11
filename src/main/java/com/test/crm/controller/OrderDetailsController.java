package com.test.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.OrderDetails;
import com.test.crm.service.OrderService;

@Controller
public class OrderDetailsController {

	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("orderDetails/getTotalPrice.do")
	@ResponseBody
	public float getTotalPrice(HttpServletRequest request, HttpServletResponse response) {

		Integer orderId = Integer.valueOf(request.getParameter("orderId"));

		float result = orderService.getTotalPrice(orderId);
		
		return result;

	}
	
	@RequestMapping("orderDetails/list.do")
	@ResponseBody
	public List<OrderDetails> getOrderDetails(HttpServletRequest request, HttpServletResponse response) {

		Integer orderId = Integer.valueOf(request.getParameter("orderId"));

		List<OrderDetails> orderDetails = orderService.getOrderDetails(orderId);
		
		return orderDetails;

	}
}
