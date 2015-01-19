package com.shpak.persistence.service;

import java.util.List;

import com.shpak.persistence.model.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	
	String deleteByShortname(String shortname);
	
	Customer findByShortname(String shortname);
	
	List<String> getAllCustomersShortname();
	
}
