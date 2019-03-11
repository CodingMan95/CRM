package com.test.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.LinkMan;
import com.test.crm.service.LinkManService;

@Controller
public class LinkManController {
	
	@Autowired
	private LinkManService linkmanService;

	@RequestMapping("linkMan/list.do")
	@ResponseBody
	public List<LinkMan> LinkManList(HttpServletRequest request, HttpServletResponse response) {

		Integer cusId = Integer.valueOf(request.getParameter("cusId"));
		List<LinkMan> list = linkmanService.selectBycusId(cusId);
		return list;

	}

	@RequestMapping("linkMan/save.do")
	@ResponseBody
	public int addLinkMan(HttpServletRequest request, HttpServletResponse response) {

		LinkMan linkMan = new LinkMan();

		Integer cusId = Integer.valueOf(request.getParameter("cusId"));
		String linkName = request.getParameter("linkName");
		String sex = request.getParameter("sex");
		String zhiwei = request.getParameter("zhiwei");
		String officePhone = request.getParameter("officePhone");
		String phone = request.getParameter("phone");

		linkMan.setCusId(cusId);
		linkMan.setLinkName(linkName);
		linkMan.setSex(sex);
		linkMan.setZhiwei(zhiwei);
		linkMan.setOfficePhone(officePhone);
		linkMan.setPhone(phone);

		int result = linkmanService.addLinkMan(linkMan);
		return result;

	}

	@RequestMapping("linkMan/update.do")
	@ResponseBody
	public int updateLinkMan(HttpServletRequest request, HttpServletResponse response) {

		LinkMan linkMan = new LinkMan();

		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer cusId = Integer.valueOf(request.getParameter("cusId"));
		String linkName = request.getParameter("linkName");
		String sex = request.getParameter("sex");
		String zhiwei = request.getParameter("zhiwei");
		String officePhone = request.getParameter("officePhone");
		String phone = request.getParameter("phone");

		linkMan.setId(id);
		linkMan.setCusId(cusId);
		linkMan.setLinkName(linkName);
		linkMan.setSex(sex);
		linkMan.setZhiwei(zhiwei);
		linkMan.setOfficePhone(officePhone);
		linkMan.setPhone(phone);

		int result = linkmanService.updateLinkMan(linkMan);
		return result;

	}

	@RequestMapping("linkMan/delete.do")
	@ResponseBody
	public int deleteLinkMan(HttpServletRequest request, HttpServletResponse response) {

		Integer id = Integer.valueOf(request.getParameter("id"));

		int result = linkmanService.deleteLinkMan(id);
		return result;

	}
}
