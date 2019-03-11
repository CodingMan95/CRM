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

import com.test.crm.entity.CustomerService;
import com.test.crm.service.CustomerServiceService;

@Controller
public class CustomerServiceController {

	@Autowired
	private CustomerServiceService csService;
	
	@RequestMapping("customerService/save.do")
	@ResponseBody
	public int addCustomerService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String serveType = request.getParameter("serveType");
		String createPeople = request.getParameter("createPeople");
		String customer = request.getParameter("customer");
		String overView = request.getParameter("overView");
		String servicerequest = request.getParameter("servicerequest");
		Date createTime = dateFormat.parse(request.getParameter("cTime"));
		
		CustomerService cService = new CustomerService();
		cService.setCreatePeople(createPeople);
		cService.setCustomer(customer);
		cService.setOverView(overView);
		cService.setServeType(serveType);
		cService.setCreateTime(createTime);
		cService.setServicerequest(servicerequest);
		int result = csService.addCustomerService(cService);
		
		return result;
	}
	
	
	@RequestMapping("customerService/list.do")
	@ResponseBody
	public List<CustomerService> list(HttpServletRequest request, HttpServletResponse response){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String state = request.getParameter("state");
		List<CustomerService> list = csService.selectByState(state);
		for (int i = 0; i < list.size(); i++) {
			String aTime = null;
			String sTime = null;
			
			Date cDate = list.get(i).getCreateTime();
			Date aDate = list.get(i).getAssignTime();
			Date sDate = list.get(i).getServiceProceTime();
			
			if (aDate != null) {
				aTime = simpleDateFormat.format(aDate);
			}else{
				aTime = null;
			}
			if (sDate != null) {
				sTime = simpleDateFormat.format(sDate);
			}else{
				sTime = null;
			}
			String cTime = simpleDateFormat.format(cDate);
			
			list.get(i).setcTime(cTime);
			list.get(i).setaTime(aTime);
			list.get(i).setsTime(sTime);
		}
		return list;
	}
	
	@RequestMapping("customerService/delete.do")
	@ResponseBody
	public int delete(HttpServletRequest request, HttpServletResponse response){
		Integer id = Integer.valueOf(request.getParameter("ids"));
		int result = csService.deleteCustomerService(id);
		return result;
	}
	
	@RequestMapping("customerService/update.do")
	@ResponseBody
	public int update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date assignTime = new Date();
		Date createTime = new Date();
		Date sTime = new Date();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String serveType = request.getParameter("serveType");
		String createPeople = request.getParameter("createPeople");
		String customer = request.getParameter("customer");
		String overView = request.getParameter("overView");
		String state = request.getParameter("state");
		String assigner = request.getParameter("assigner");
		String aTime = request.getParameter("aTime");
		String cTime = request.getParameter("cTime");
		String servicerequest = request.getParameter("servicerequest");
		String serviceProce = request.getParameter("serviceProce");
		String sProceTime = request.getParameter("sTime");
		String serviceProceResult = request.getParameter("serviceProceResult");
		String myd = request.getParameter("myd");
		String serviceProcePeople = request.getParameter("serviceProcePeople");
		
		if (null != aTime) {
			assignTime = dateFormat.parse(aTime);
		}
		if (null != cTime) {
			createTime = dateFormat.parse(cTime);
		}
		if (null != sProceTime) {
			sTime = dateFormat.parse(sProceTime);
		}
		
		CustomerService cService = new CustomerService();
		cService.setId(id);
		cService.setState(state);
		cService.setCreatePeople(createPeople);
		cService.setCustomer(customer);
		cService.setOverView(overView);
		cService.setServeType(serveType);
		cService.setAssigner(assigner);
		cService.setServiceProce(serviceProce);
		cService.setServiceProcePeople(serviceProcePeople);
		cService.setServiceProceResult(serviceProceResult);
		cService.setMyd(myd);
		
		if (sTime != null) {
			cService.setServiceProceTime(sTime);
		}
		if (assignTime != null) {
			cService.setAssignTime(assignTime);
		}
		if (createTime != null) {
			cService.setCreateTime(createTime);
		}
		cService.setServicerequest(servicerequest);
		
		int result = csService.updateCustomerService(cService);
		return result;
	}
}
