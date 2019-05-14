package com.meddomain.dao;

import java.util.List;

import com.meddomain.entity.User;

public interface UserDao {

	void merge(User user);
	
	List<User> getUserList();

	User getUser(Class<User> class1, Integer userId);

	void delete(int userId);
	
}
