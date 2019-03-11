package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.SaleChance;

public interface SaleChanceDao {
	
	public List<SaleChance> selectAll();
	public int addSaleChance(SaleChance saleChance);
	public int delete(Integer id);
	public List<SaleChance> searchSaleChance(String customerName);
	public int update(SaleChance saleChance);
	public int updateState(Integer id);
	
}
