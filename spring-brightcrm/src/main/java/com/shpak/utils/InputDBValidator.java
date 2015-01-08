package com.shpak.utils;

import com.shpak.persistence.model.Customer;
import com.shpak.persistence.model.User;

public interface InputDBValidator {
	
	String validateUser(User user);
	
	String validateCustomer(Customer customer);
	
}
