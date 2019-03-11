package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.CustomerService;

public interface CustomerServiceDao {

	public int addCustomerService(CustomerService cService);
	public int deleteCustomerService(Integer id);
	public List<CustomerService> selectByState(String state);
	public int updateCustomerService(CustomerService cService);
}
