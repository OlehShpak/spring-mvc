package com.shpak.persistence.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import com.shpak.config.PersistenceConfig;
import com.shpak.persistence.model.Customer;

@ContextConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTests {

	@Autowired
	protected CustomerService customerService;
	
	
	@Test
	public void findByShortnameTest(){
		
		Customer cust = customerService.findByShortname("BP");
		assertTrue(cust!=null);
		assertEquals("BP", cust.getShortname());
			
	}
	
	@Test
	public void getAllCustomersShortnameTest(){
		
		List<String> list = customerService.getAllCustomersShortname();
		assertEquals(6,list.size());
		
	}
	
	@Test
	public void addCustomerTest(){
		
		Customer cust = customerService.findByShortname("BP");
		cust.setShortname("wrong customer");
		cust.setId(null);
		cust.setDeals(null);
		customerService.addCustomer(cust);
		Customer cust2 = customerService.findByShortname("wrong customer");
		assertEquals("wrong customer", cust2.getShortname());
		
	}
	
	@Test
	public void deleteByShortnameTest(){
		
		Customer cust = customerService.findByShortname("wrong customer");
		assertTrue(cust!=null);
		customerService.deleteByShortname("wrong customer");
		assertFalse(null==cust);
	
	}
	
	
}
