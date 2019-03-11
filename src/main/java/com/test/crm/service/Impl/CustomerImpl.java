package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.CustomerDao;
import com.test.crm.entity.Contact;
import com.test.crm.entity.Customer;
import com.test.crm.entity.CustomerLoss;
import com.test.crm.entity.CustomerReprieve;
import com.test.crm.entity.DataDic;
import com.test.crm.entity.Order;
import com.test.crm.entity.OrderDetails;
import com.test.crm.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> selectAll() {
		return customerDao.selectAll();
	}

	@Override
	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<DataDic> findDataDic(String dataDicName) {
		return customerDao.findDataDic(dataDicName);
	}

	@Override
	public int delete(Integer id) {
		return customerDao.delete(id);
	}

	@Override
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	@Override
	public List<CustomerLoss> selectLossCustomer() {
		// TODO Auto-generated method stub
		return customerDao.selectLossCustomer();
	}

	@Override
	public List<CustomerReprieve> selectCustomerReprieveById(Integer lossId) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerReprieveById(lossId);
	}

	@Override
	public CustomerLoss findCustomerLossById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerLossById(id);
	}

	@Override
	public int addCustomerReprieve(CustomerReprieve customerReprieve) {
		// TODO Auto-generated method stub
		return customerDao.addCustomerReprieve(customerReprieve);
	}

	@Override
	public int updateCustomerReprieve(CustomerReprieve customerReprieve) {
		// TODO Auto-generated method stub
		return customerDao.updateCustomerReprieve(customerReprieve);
	}

	@Override
	public int deleteCustomerReprieve(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.deleteCustomerReprieve(id);
	}

	@Override
	public int updateCustomerLossState(CustomerLoss customerLoss) {
		// TODO Auto-generated method stub
		return customerDao.updateCustomerLossState(customerLoss);
	}


}
