package com.test.crm.dao;

import java.util.List;

import com.test.crm.entity.LinkMan;

public interface LinkManDao {

	/*
	 * 联系人的增删改查
	 */
	public List<LinkMan> selectBycusId(Integer cusId);
	public int addLinkMan(LinkMan linkMan);
	public int deleteLinkMan(Integer id);
	public int updateLinkMan(LinkMan linkMan);
	
}
