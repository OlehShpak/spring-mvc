package com.shpak.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.dao.UserDao;
import com.shpak.persistence.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		
		userDao.addUser(user);
		
	}
	
	@Override
	public User findByUserName(String username){
		
		return userDao.findByUserName(username);
	}

}
