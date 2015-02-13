package com.shpak.persistence.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shpak.config.PersistenceConfig;
import com.shpak.persistence.model.Deal;

@ContextConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DealServiceTests {

	@Autowired
	protected DealService dealService;
	
	@Test
	public void findByCreatedDateBetweenTest(){
		
		List<Deal> list = dealService.findByCreatedDateBetween(new Date(1420063200000L), new Date(1421359200000L));
		assertEquals(8,list.size());

	}
	
	@Test
	public void findByDeadlineBetweenTest(){
		
		List<Deal> list = dealService.findByDeadlineBetween(new Date(1420063200000L), new Date(1422396000000L));
		assertEquals(3,list.size());
		
	}
	
	
	@Test
	public void findBigDealsTest(){
		
		List<Deal> list = dealService.findBigDeals(new BigDecimal(4000));
		assertEquals(2,list.size());
		
	}
	
	@Test
	public void employeeEfficiencyTest(){
		
		List<Deal> list = dealService.employeeEfficiency("tester");
		assertEquals(3,list.size());
		
	}
	
	
}
