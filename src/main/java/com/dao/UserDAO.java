package com.dao;

import com.entity.User;

public interface UserDAO {
	public User login(String name,String password);
	
}
