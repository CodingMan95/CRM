package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.SaleChanceDao;
import com.test.crm.entity.SaleChance;
import com.test.crm.service.SaleChanceService;

@Service
public class SaleChanceImpl implements SaleChanceService{
	
	@Autowired
	private SaleChanceDao saleChanceDao;

	@Override
	public List<SaleChance> selectAll() {
		return saleChanceDao.selectAll();
	}

	@Override
	public int addSaleChance(SaleChance saleChance) {
		return saleChanceDao.addSaleChance(saleChance);
	}

	@Override
	public int delete(Integer id) {
		return saleChanceDao.delete(id);
	}

	@Override
	public List<SaleChance> searchSaleChance(String customerName) {
		return saleChanceDao.searchSaleChance(customerName);
	}

	@Override
	public int update(SaleChance saleChance) {
		return saleChanceDao.update(saleChance);
	}

	@Override
	public int updateState(Integer id) {
		// TODO Auto-generated method stub
		return saleChanceDao.updateState(id);
	}

}
