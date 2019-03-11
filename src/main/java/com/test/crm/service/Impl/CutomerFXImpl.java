package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.CutomerFXDao;
import com.test.crm.entity.Customer;
import com.test.crm.entity.CustomerInfo;
import com.test.crm.service.CutomerFXService;

@Service
public class CutomerFXImpl implements CutomerFXService{
	
	@Autowired
	private CutomerFXDao cutomerFXDao;

	@Override
	public List<CustomerInfo> findCutomerGx() {
		// TODO Auto-generated method stub
		return cutomerFXDao.findCutomerGx();
	}

	@Override
	public List<Customer> findCutomerGc() {
		// TODO Auto-generated method stub
		return cutomerFXDao.findCutomerGc();
	}

}
