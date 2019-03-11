package com.test.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.Customer;
import com.test.crm.entity.DataDic;
import com.test.crm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	//查询全部客户信息
	@RequestMapping("customer/list.do")
	@ResponseBody
	public List<Customer> list(HttpServletRequest request, HttpServletResponse response) {

		List<Customer> list = customerService.selectAll();
		return list;

	}

	//添加客户信息
	@RequestMapping("customer/save.do")
	@ResponseBody
	public int save(HttpServletRequest request, HttpServletResponse response) {

		Customer customer = new Customer();

		String khno = request.getParameter("khno");
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String cusManager = request.getParameter("cusManager");
		String level = request.getParameter("level");
		String myd = request.getParameter("myd");
		String xyd = request.getParameter("xyd");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postCode");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String webSite = request.getParameter("webSite");
		String yyzzzch = request.getParameter("yyzzzch");
		String fr = request.getParameter("fr");
		String zczj = request.getParameter("zczj");
		String nyye = request.getParameter("nyye");
		String khyh = request.getParameter("khyh");
		String khzh = request.getParameter("khzh");
		String dsdjh = request.getParameter("dsdjh");
		String gsdjh = request.getParameter("gsdjh");

		customer.setKhno(khno);
		customer.setName(name);
		customer.setArea(area);
		customer.setCusManager(cusManager);
		customer.setLevel(level);
		customer.setMyd(myd);
		customer.setXyd(xyd);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setPostCode(postCode);
		customer.setFax(fax);
		customer.setWebSite(webSite);
		customer.setYyzzzch(yyzzzch);
		customer.setFr(fr);
		customer.setZczj(zczj);
		customer.setNyye(nyye);
		customer.setKhyh(khyh);
		customer.setKhzh(khzh);
		customer.setDsdjh(dsdjh);
		customer.setGsdjh(gsdjh);

		int result = customerService.addCustomer(customer);
		return result;

	}

	//
	@RequestMapping("findDataDic.do")
	@ResponseBody
	public List<DataDic> findDataDic(HttpServletRequest request, HttpServletResponse response) {

		String dataDicName = request.getParameter("dataDicName");
		List<DataDic> list = customerService.findDataDic(dataDicName);
		return list;

	}

	//删除客户信息
	@RequestMapping("customer/delete.do")
	@ResponseBody
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("ids"));
		int result = customerService.delete(id);
		return result;
	}

	//更新客户信息
	@RequestMapping("customer/update.do")
	@ResponseBody
	public int update(HttpServletRequest request, HttpServletResponse response) {

		Customer customer = new Customer();

		Integer id = Integer.valueOf(request.getParameter("id"));
		// String khno = request.getParameter("khno");
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String cusManager = request.getParameter("cusManager");
		String level = request.getParameter("level");
		String myd = request.getParameter("myd");
		String xyd = request.getParameter("xyd");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postCode");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String webSite = request.getParameter("webSite");
		String yyzzzch = request.getParameter("yyzzzch");
		String fr = request.getParameter("fr");
		String zczj = request.getParameter("zczj");
		String nyye = request.getParameter("nyye");
		String khyh = request.getParameter("khyh");
		String khzh = request.getParameter("khzh");
		String dsdjh = request.getParameter("dsdjh");
		String gsdjh = request.getParameter("gsdjh");

		// customer.setKhno(khno);
		customer.setId(id);
		customer.setName(name);
		customer.setArea(area);
		customer.setCusManager(cusManager);
		customer.setLevel(level);
		customer.setMyd(myd);
		customer.setXyd(xyd);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setPostCode(postCode);
		customer.setFax(fax);
		customer.setWebSite(webSite);
		customer.setYyzzzch(yyzzzch);
		customer.setFr(fr);
		customer.setZczj(zczj);
		customer.setNyye(nyye);
		customer.setKhyh(khyh);
		customer.setKhzh(khzh);
		customer.setDsdjh(dsdjh);
		customer.setGsdjh(gsdjh);

		int result = customerService.update(customer);
		return result;
	}

	//通过id查找唯一用户
	@RequestMapping("customer/findById.do")
	@ResponseBody
	public Customer findById(HttpServletRequest request, HttpServletResponse response) {

		Integer id = Integer.valueOf(request.getParameter("id"));
		Customer customer = customerService.findById(id);
		return customer;

	}
}
