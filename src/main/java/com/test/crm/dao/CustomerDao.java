package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.Customer;
import com.test.crm.entity.CustomerLoss;
import com.test.crm.entity.CustomerReprieve;
import com.test.crm.entity.DataDic;
import com.test.crm.entity.Order;
import com.test.crm.entity.OrderDetails;

public interface CustomerDao {

	public List<Customer> selectAll();
	public int addCustomer(Customer customer);
	public List<DataDic> findDataDic(String dataDicName);
	public int delete(Integer id);
	public int update(Customer customer);
	public Customer findById(Integer id);
	
	public List<Order> selectOrder(Integer cusId);
	
	public Order selectOrderById(Integer id);
	
	public float getTotalPrice(Integer orderId);
	public List<OrderDetails> getOrderDetails(Integer orderId);
	
	public List<CustomerLoss> selectLossCustomer();
	public CustomerLoss findCustomerLossById(Integer id);
	public int updateCustomerLossState(CustomerLoss customerLoss);
	
	public List<CustomerReprieve> selectCustomerReprieveById(Integer lossId);
	public int addCustomerReprieve(CustomerReprieve customerReprieve);
	public int updateCustomerReprieve(CustomerReprieve customerReprieve);
	public int deleteCustomerReprieve(Integer id);
}
