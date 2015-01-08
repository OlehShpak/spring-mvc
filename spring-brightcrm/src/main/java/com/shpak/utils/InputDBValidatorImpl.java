package com.shpak.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.Customer;
import com.shpak.persistence.model.User;

@Service
@Transactional
public class InputDBValidatorImpl implements InputDBValidator {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public String validateUser(User user){		
		//Validating username
		List<?> result = entityManager.createQuery("from User where username = ?").setParameter(1, user.getUsername())
			.getResultList();
		if (result.size() > 0){
			return "This username already exist";
		}
		//Validating email
		result = entityManager.createQuery("from User where email = ?").setParameter(1, user.getEmail())
				.getResultList(); 
		if (result.size() > 0){
			return "This email already registered";
		}
		//Validating phonenumber
		result = entityManager.createQuery("from User where phonenumber = ?").setParameter(1, user.getPhonenumber())
				.getResultList(); 
		if (result.size() > 0){
			return "This phonenumber already registered";
		}
		return "ok";
	}
	
	@Override
	public String validateCustomer(Customer customer){		
		//Validating shortname
		List<?> result = entityManager.createQuery("from Customer where shortname = ?").setParameter(1, customer.getShortname())
			.getResultList();
		if (result.size() > 0){
			return "This shortname already exist";
		}
		//Validating email
		result = entityManager.createQuery("from Customer where email = ?").setParameter(1, customer.getEmail())
				.getResultList(); 
		if (result.size() > 0){
			return "This email already registered";
		}
		//Validating phonenumber
		result = entityManager.createQuery("from Customer where phonenumber = ?").setParameter(1, customer.getPhonenumber())
				.getResultList(); 
		if (result.size() > 0){
			return "This phonenumber already registered";
		}
		return "ok";
	}
	
}
