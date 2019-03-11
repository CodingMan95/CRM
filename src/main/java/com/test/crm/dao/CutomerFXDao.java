package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.Customer;
import com.test.crm.entity.CustomerInfo;

public interface CutomerFXDao {
	
	public List<CustomerInfo> findCutomerGx();
	public List<Customer> findCutomerGc();

}
