package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.CustomerServiceDao;
import com.test.crm.entity.CustomerService;
import com.test.crm.service.CustomerServiceService;

@Service
public class CustomerServiceImpl implements CustomerServiceService{

	@Autowired
	private CustomerServiceDao customerServiceDao;
	
	@Override
	public int addCustomerService(com.test.crm.entity.CustomerService cService) {
		// TODO Auto-generated method stub
		return customerServiceDao.addCustomerService(cService);
	}

	@Override
	public int deleteCustomerService(Integer id) {
		// TODO Auto-generated method stub
		return customerServiceDao.deleteCustomerService(id);
	}

	@Override
	public List<CustomerService> selectByState(String state) {
		// TODO Auto-generated method stub
		return customerServiceDao.selectByState(state);
	}

	@Override
	public int updateCustomerService(CustomerService cService) {
		// TODO Auto-generated method stub
		return customerServiceDao.updateCustomerService(cService);
	}

}
