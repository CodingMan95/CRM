package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.ContactDao;
import com.test.crm.entity.Contact;
import com.test.crm.service.ContactService;

@Service
public class ContactImpl implements ContactService{
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public List<Contact> selectContact(Integer cusId) {
		// TODO Auto-generated method stub
		return contactDao.selectContact(cusId);
	}

	@Override
	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactDao.addContact(contact);
	}

	@Override
	public int deleteContact(Integer id) {
		// TODO Auto-generated method stub
		return contactDao.deleteContact(id);
	}

	@Override
	public int updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactDao.updateContact(contact);
	}

}
