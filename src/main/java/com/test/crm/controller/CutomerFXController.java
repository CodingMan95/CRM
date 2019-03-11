package com.test.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.Customer;
import com.test.crm.entity.CustomerInfo;
import com.test.crm.service.CutomerFXService;

@Controller
public class CutomerFXController {

	@Autowired
	private CutomerFXService cutomerFXService;
	
	//客户贡献分析
	@RequestMapping("customer/findCutomerGx.do")
	@ResponseBody
	public List<CustomerInfo> findCutomerGx(HttpServletRequest request){
		List<CustomerInfo> list = cutomerFXService.findCutomerGx();
		return list;
	}
	
	//客户构成分析
	@RequestMapping("customer/findCutomerGc.do")
	@ResponseBody
	public List<Customer> findCutomerGc(HttpServletRequest request){
		List<Customer> list = cutomerFXService.findCutomerGc();
		
		for (int i = 0; i < list.size(); i++) {
			String level = list.get(i).getLevel();
			if (level.equals("普通客户")) {
				list.get(i).setCustomerLevel("E");
			}
			if (level.equals("大客户") ) {
				list.get(i).setCustomerLevel("D");
			}
			if (level.equals("合作伙伴")){
				list.get(i).setCustomerLevel("C");
			}
			if (level.equals("重点开发客户")) {
				list.get(i).setCustomerLevel("B");
			}
			if (level.equals("战略合作伙伴")) {
				list.get(i).setCustomerLevel("A");
			}
		}
		
		return list;
	}
}
