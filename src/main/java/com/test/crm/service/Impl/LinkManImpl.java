package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.LinkManDao;
import com.test.crm.entity.LinkMan;
import com.test.crm.service.LinkManService;

@Service
public class LinkManImpl implements LinkManService{
	
	@Autowired
	private LinkManDao lService;

	@Override
	public List<LinkMan> selectBycusId(Integer cusId) {
		// TODO Auto-generated method stub
		return lService.selectBycusId(cusId);
	}

	@Override
	public int addLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return lService.addLinkMan(linkMan);
	}

	@Override
	public int deleteLinkMan(Integer id) {
		// TODO Auto-generated method stub
		return lService.deleteLinkMan(id);
	}

	@Override
	public int updateLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return lService.updateLinkMan(linkMan);
	}

}
