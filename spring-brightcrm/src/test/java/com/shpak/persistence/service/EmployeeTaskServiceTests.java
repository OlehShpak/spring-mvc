package com.shpak.persistence.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shpak.config.PersistenceConfig;
import com.shpak.persistence.model.EmployeeTask;

@ContextConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeTaskServiceTests {
	
	@Autowired
	protected EmployeeTaskService employeeTaskService;
	
	@Test
	public void findByEmployeeFullnameTest() {
		
		List<EmployeeTask> list = employeeTaskService.findByEmployeeFullname("fullname");
		assertEquals(6,list.size());
		
	}
	
	@Test
	public void findOne(){
		
		EmployeeTask task = employeeTaskService.findOne(2L);
		assertTrue(task!=null);
		assertEquals("Its task number 1", task.getDescription());
		
	}

}
