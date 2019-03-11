package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.DataDicDao;
import com.test.crm.entity.DataDic;
import com.test.crm.service.DataDicService;

@Service
public class DataDicImpl implements DataDicService{
	
	@Autowired
	private DataDicDao dataDicDao;

	@Override
	public List<DataDic> selectDataDic() {
		// TODO Auto-generated method stub
		return dataDicDao.selectDataDic();
	}

	@Override
	public int addDataDic(DataDic dataDic) {
		// TODO Auto-generated method stub
		return dataDicDao.addDataDic(dataDic);
	}

	@Override
	public int updateDataDic(DataDic dataDic) {
		// TODO Auto-generated method stub
		return dataDicDao.updateDataDic(dataDic);
	}

	@Override
	public int deleteDataDic(Integer id) {
		// TODO Auto-generated method stub
		return dataDicDao.deleteDataDic(id);
	}

	@Override
	public List<DataDic> findDataDicName() {
		// TODO Auto-generated method stub
		return dataDicDao.findDataDicName();
	}

}
