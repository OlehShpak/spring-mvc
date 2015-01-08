package com.shpak.persistence.dao;


import com.shpak.persistence.model.User;

public interface UserDao {

	User findByUserName(String username);
	void addUser(User user);
}