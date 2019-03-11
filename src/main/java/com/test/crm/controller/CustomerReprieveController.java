package com.test.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.CustomerReprieve;
import com.test.crm.service.CustomerService;

@Controller
public class CustomerReprieveController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("customerReprieve/list.do")
	@ResponseBody
	public List<CustomerReprieve> getCustomerReprieve(HttpServletRequest request){
		
		Integer lossId = Integer.valueOf(request.getParameter("lossId"));
		
		List<CustomerReprieve> list = customerService.selectCustomerReprieveById(lossId);
		
		return list;
	}
	
	@RequestMapping("customerReprieve/save.do")
	@ResponseBody
	public int addCustomerReprieve(HttpServletRequest request){
		
		Integer lossId = Integer.valueOf(request.getParameter("lossId"));
		String measure = request.getParameter("measure");
		
		CustomerReprieve customerReprieve = new CustomerReprieve();
		
		customerReprieve.setLossId(lossId);
		customerReprieve.setMeasure(measure);

		int result = customerService.addCustomerReprieve(customerReprieve);
		return result;
	}
	
	@RequestMapping("customerReprieve/update.do")
	@ResponseBody
	public int updateCustomerReprieve(HttpServletRequest request){
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer lossId = Integer.valueOf(request.getParameter("lossId"));
		String measure = request.getParameter("measure");
		
		CustomerReprieve customerReprieve = new CustomerReprieve();
		
		customerReprieve.setLossId(lossId);
		customerReprieve.setMeasure(measure);
		customerReprieve.setId(id);

		int result = customerService.updateCustomerReprieve(customerReprieve);
		return result;
	}
	
	@RequestMapping("customerReprieve/delete.do")
	@ResponseBody
	public int deleteCustomerReprieve(HttpServletRequest request){
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		int result = customerService.deleteCustomerReprieve(id);
		
		return result;
	}
}
