package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.ProductDao;
import com.test.crm.entity.Product;
import com.test.crm.service.ProductService;

@Service
public class ProductImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> selectProduct() {
		// TODO Auto-generated method stub
		return productDao.selectProduct();
	}

}
