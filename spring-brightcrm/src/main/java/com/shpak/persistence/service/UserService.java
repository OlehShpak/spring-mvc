package com.shpak.persistence.service;

import com.shpak.persistence.model.User;

public interface UserService {
	
	void addUser(User user);
	public User findByUserName(String username);
}
