package com.shpak.persistence.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.shpak.persistence.model.Customer;
import com.shpak.persistence.repository.CustomerRepository;
import com.shpak.persistence.repository.DealRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DealRepository dealRepository;
	
	@Override
	public void addCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
		
	}

	@Override
	public String deleteByShortname(String shortname) {
		
	 Customer cust = findByShortname(shortname);						
	 if (cust!=null){														//make sure that Customer exists
	 dealRepository.deleteByCustomerShortname(cust.getShortname());	 
	 customerRepository.deleteByShortname(shortname);
	 return "Customer deleted successfully";
	 } else {
		 return "Customer doesn't exist";
	 }
		
	}

	@Override
	public Customer findByShortname(String shortname) {
		List<Customer> result = customerRepository.findByShortname(shortname);
		if (result.size()>0){
		return result.get(0);
		}else {
		return null;	
		}
		
	}

	@Override
	@Cacheable
	public List<String> getAllCustomersShortname() {
		List<String> stringList = customerRepository.getAllCustomersShortname();
		return stringList;
	}

}
