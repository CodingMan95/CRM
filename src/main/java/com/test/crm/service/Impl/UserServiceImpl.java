package com.test.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crm.dao.UserDao;
import com.test.crm.entity.User;
import com.test.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User selectUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.selectUserByName(userName);
	}


	@Override
	public List<User> selectLimit() {
		// TODO Auto-generated method stub
		return userDao.selectLimit();
	}


	@Override
	public int modifyPassword(User user) {
		// TODO Auto-generated method stub
		return userDao.modifyPassword(user);
	}


	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}


	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

}
