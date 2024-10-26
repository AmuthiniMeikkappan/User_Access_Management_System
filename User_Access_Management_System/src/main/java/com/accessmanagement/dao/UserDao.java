package com.accessmanagement.dao;

import com.accessmanagement.model.User;

public interface UserDao {
	
	int addUser(User user);
	User getUser(String username);
}
