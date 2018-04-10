package com.service;

import com.entity.User;

public interface UserService {
	public User login(String name, String password);
}
