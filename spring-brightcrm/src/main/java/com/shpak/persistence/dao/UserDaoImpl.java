package com.shpak.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.User;
import com.shpak.persistence.model.UserRole;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		
		List<User> users = new ArrayList<User>();

		users = entityManager.createQuery("from User where username = ?").setParameter(1, username)
				.getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void addUser(User user) {
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		user.getUserRole().add(userRole);
		userRole.setUser(user);
		entityManager.persist(user);
		entityManager.persist(userRole);
	}

}
