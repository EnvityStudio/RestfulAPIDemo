package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.entity.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public User login(String name,String password) {
		return userDao.login(name, password);
	}

}
