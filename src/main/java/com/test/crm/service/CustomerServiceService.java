package com.test.crm.service;

import java.util.List;

import com.test.crm.entity.CustomerService;

public interface CustomerServiceService {
	
	public int addCustomerService(CustomerService cService);
	public int deleteCustomerService(Integer id);
	public List<CustomerService> selectByState(String state);
	public int updateCustomerService(CustomerService cService);

}
