package com.test.crm.service;

import java.util.List;

import com.test.crm.entity.User;

public interface UserService {

	public User selectUserByName(String userName);
	public int modifyPassword(User user);
	public List<User> selectLimit();
	
	public List<User> findAllUser();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(Integer id);
	
}
