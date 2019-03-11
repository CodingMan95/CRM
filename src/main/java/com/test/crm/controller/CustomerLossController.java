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

import com.test.crm.entity.CustomerLoss;
import com.test.crm.service.CustomerService;

@Controller
public class CustomerLossController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("customerLoss/list.do")
	@ResponseBody
	public List<CustomerLoss> selectLossCustomer(HttpServletRequest request, HttpServletResponse response) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<CustomerLoss> list = customerService.selectLossCustomer();

		for (int i = 0; i < list.size(); i++) {
			Date lastOrderTime = list.get(i).getLastOrderTime();
			Date confirmLossTime = list.get(i).getConfirmLossTime();

			String lTime = null;
			String cTime = null;

			if (null == lastOrderTime) {
				lTime = null;
			} else {
				lTime = dateFormat.format(lastOrderTime);
			}
			if (null == confirmLossTime) {
				cTime = null;
			} else {

				cTime = dateFormat.format(confirmLossTime);
			}

			list.get(i).setlTime(lTime);
			list.get(i).setcTime(cTime);
		}

		return list;
	}

	@RequestMapping("customerLoss/findById.do")
	@ResponseBody
	public CustomerLoss findById(HttpServletRequest request) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Integer id = Integer.valueOf(request.getParameter("id"));

		CustomerLoss customerLoss = customerService.findCustomerLossById(id);
		Date oDate = customerLoss.getLastOrderTime();
		String lTime = dateFormat.format(oDate);
		customerLoss.setlTime(lTime);

		return customerLoss;
	}

	@RequestMapping("customerLoss/confirmLoss.do")
	@ResponseBody
	public int updateState(HttpServletRequest request) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		Integer id = Integer.valueOf(request.getParameter("id"));
		CustomerLoss customerLoss = new CustomerLoss();
		customerLoss.setId(id);
		customerLoss.setConfirmLossTime(date);
		
		int result = customerService.updateCustomerLossState(customerLoss);

		return result;
	}
}
