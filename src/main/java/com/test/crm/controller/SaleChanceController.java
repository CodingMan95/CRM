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

import com.test.crm.entity.SaleChance;
import com.test.crm.service.SaleChanceService;

@Controller
public class SaleChanceController {

	@Autowired
	private SaleChanceService saleChanceService;
	
	@RequestMapping("list.do")
	@ResponseBody
	public List<SaleChance> selectAll() throws Exception{
		
		List<SaleChance> list = saleChanceService.selectAll();
		for(int i = 0; i < list.size(); i++){
			Date createTime = list.get(i).getCreateTime();
			Date assignTime = list.get(i).getAssignTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cTime = dateFormat.format(createTime);
			String aTime = dateFormat.format(assignTime);
		    list.get(i).setcTime(cTime);
		    list.get(i).setaTime(aTime);
		}
		return list;
		
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public int save(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SaleChance saleChance = new SaleChance();
		
		String customerName = request.getParameter("customerName");
		String chanceSource = request.getParameter("chanceSource");
		Integer cgjl = Integer.valueOf(request.getParameter("cgjl"));
		String overview = request.getParameter("overView");
		String linkMan = request.getParameter("linkMan");
		String linkPhone = request.getParameter("linkPhone");
		String description = request.getParameter("description");
		String createMan = request.getParameter("createMan");
	
		Date createTime = new Date();
		Date assignTime = new Date();
		createTime = df.parse(request.getParameter("createTime"));
		assignTime = df.parse(request.getParameter("assignTime"));
		
		String assignMan = request.getParameter("assignMan");
		//Integer state = Integer.valueOf(request.getParameter("state"));

		saleChance.setCustomerName(customerName);
		saleChance.setChanceSource(chanceSource);
		saleChance.setCgjl(cgjl);
		saleChance.setOverView(overview);
		saleChance.setLinkMan(linkMan);
		saleChance.setLinkPhone(linkPhone);
		saleChance.setDescription(description);
		saleChance.setCreateMan(createMan);
		
		if (null == createTime || null == assignTime) {
			saleChance.setCreateTime(null);
			saleChance.setAssignTime(null);
		} else {
			saleChance.setCreateTime(createTime);
			saleChance.setAssignTime(assignTime);
		}
		saleChance.setAssignMan(assignMan);
		//saleChance.setState(state);
		
		saleChance.setAssignMan(assignMan);
		
		int result = saleChanceService.addSaleChance(saleChance);
		if (result == 1) {
			System.out.println("添加成功！");
		} else {
			System.out.println("添加失败！");
		}
		return result;
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public int delete(HttpServletRequest request, HttpServletResponse response){
		Integer id = Integer.valueOf(request.getParameter("ids"));
		int result = saleChanceService.delete(id);
		return result;
	}
	
	/*@RequestMapping("searchSaleChance.do")
	@ResponseBody
	public List<SaleChance> searchSaleChance(HttpServletRequest request, HttpServletResponse response){
		String customerName = request.getParameter("customerName");
		List<SaleChance> result = saleChanceService.searchSaleChance(customerName);
		return result;
	}*/

	@RequestMapping("update.do")
	@ResponseBody
	public int update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SaleChance saleChance = new SaleChance();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String customerName = request.getParameter("customerName");
		String chanceSource = request.getParameter("chanceSource");
		Integer cgjl = Integer.valueOf(request.getParameter("cgjl"));
		String overview = request.getParameter("overView");
		String linkMan = request.getParameter("linkMan");
		String linkPhone = request.getParameter("linkPhone");
		String description = request.getParameter("description");
		String createMan = request.getParameter("createMan");
	
		Date createTime = new Date();
		Date assignTime = new Date();
		createTime = df.parse(request.getParameter("createTime"));
		assignTime = df.parse(request.getParameter("assignTime"));
		
		String assignMan = request.getParameter("assignMan");
		//Integer state = Integer.valueOf(request.getParameter("state"));

		saleChance.setId(id);
		saleChance.setCustomerName(customerName);
		saleChance.setChanceSource(chanceSource);
		saleChance.setCgjl(cgjl);
		saleChance.setOverView(overview);
		saleChance.setLinkMan(linkMan);
		saleChance.setLinkPhone(linkPhone);
		saleChance.setDescription(description);
		saleChance.setCreateMan(createMan);
		
		if (null == createTime || null == assignTime) {
			saleChance.setCreateTime(null);
			saleChance.setAssignTime(null);
		} else {
			saleChance.setCreateTime(createTime);
			saleChance.setAssignTime(assignTime);
		}
		saleChance.setAssignMan(assignMan);
		//saleChance.setState(state);
		
		saleChance.setAssignMan(assignMan);
		int result = saleChanceService.update(saleChance);
		if (assignMan != null) {
			saleChanceService.updateState(id);
		}
		return result;
	}
}
