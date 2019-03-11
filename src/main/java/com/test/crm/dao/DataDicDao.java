package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.DataDic;

public interface DataDicDao {

	public List<DataDic> selectDataDic();
	public List<DataDic> findDataDicName();
	public int addDataDic(DataDic dataDic);
	public int updateDataDic(DataDic dataDic);
	public int deleteDataDic(Integer id);
	
}
