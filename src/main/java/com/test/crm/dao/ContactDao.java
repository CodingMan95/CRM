package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.Contact;

public interface ContactDao {

	/*
	 * 交往记录的增删改查
	 */
	public List<Contact> selectContact(Integer cusId);
	public int addContact(Contact contact);
	public int deleteContact(Integer id);
	public int updateContact(Contact contact);
	
}
