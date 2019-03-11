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

import com.test.crm.entity.Contact;
import com.test.crm.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("contact/list.do")
	@ResponseBody
	public List<Contact> selectContact(HttpServletRequest request, HttpServletResponse response) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Integer cusId = Integer.valueOf(request.getParameter("cusId"));

		List<Contact> contacts = contactService.selectContact(cusId);

		for (int i = 0; i < contacts.size(); i++) {

			Date contactTime = contacts.get(i).getContactTime();
			String cTime = dateFormat.format(contactTime);
			contacts.get(i).setcTime(cTime);
		}

		return contacts;

	}

	@RequestMapping("contact/save.do")
	@ResponseBody
	public int addContact(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Contact contact = new Contact();

		Integer cusId = Integer.valueOf(request.getParameter("cusId"));
		String address = request.getParameter("address");
		String overView = request.getParameter("overView");

		String contactTime = request.getParameter("cTime");

		Date time = df.parse(contactTime);

		contact.setContactTime(time);
		contact.setAddress(address);
		contact.setCusId(cusId);
		contact.setOverView(overView);

		int result = contactService.addContact(contact);
		return result;

	}

	@RequestMapping("contact/update.do")
	@ResponseBody
	public int updateContact(HttpServletRequest request, HttpServletResponse response) throws Exception {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Contact contact = new Contact();

		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer cusId = Integer.valueOf(request.getParameter("cusId"));
		String address = request.getParameter("address");
		String overView = request.getParameter("overView");

		String contactTime = request.getParameter("cTime");

		Date time = df.parse(contactTime);

		contact.setId(id);
		contact.setContactTime(time);
		contact.setAddress(address);
		contact.setCusId(cusId);
		contact.setOverView(overView);

		int result = contactService.updateContact(contact);
		return result;

	}

	@RequestMapping("contact/delete.do")
	@ResponseBody
	public int deleteContact(HttpServletRequest request, HttpServletResponse response) {

		Integer id = Integer.valueOf(request.getParameter("id"));

		int result = contactService.deleteContact(id);
		return result;

	}
	
}
