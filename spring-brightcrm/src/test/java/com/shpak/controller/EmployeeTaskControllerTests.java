package com.shpak.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.awt.print.Printable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.shpak.persistence.model.EmployeeTask;
import com.shpak.persistence.model.User;
import com.shpak.persistence.service.EmployeeTaskService;
import com.shpak.persistence.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTaskControllerTests {
	
	@Mock
	private Principal principalMock;
	
	@Mock
	private UserService userServiceMock;
	
	@Mock
	private EmployeeTaskService employeeTaskServiceMock;
	
	@InjectMocks
	private EmployeeTaskController employeeTaskController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {

        // Setup Spring test in standalone mode
		 mockMvc = MockMvcBuilders.standaloneSetup(employeeTaskController)
				 	.setHandlerExceptionResolvers(exceptionResolver())
	                .setValidator(validator())
	                .setViewResolvers(viewResolver())
	                .build();
    }
	
	@Test
	public void employeeTaskAddGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/employeeTask/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/employeeTask/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/employeeTask/add.jsp"))
		.andExpect(model().attribute("task" , notNullValue()));
	
	}
	
	@Test
	public void employeeTaskAddEmptyPostTest()  throws Exception {
		
		this.mockMvc.perform(post("/crm/employeeTask/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/employeeTask/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/employeeTask/add.jsp"))
		.andExpect(model().attribute("task" , notNullValue()))
		.andExpect(model().errorCount(2));
	
	}
	
	
	@Test
	public void employeeAccomplishGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/employeeTask/accomplish"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/employeeTask/accomplish"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/employeeTask/accomplish.jsp"))
		.andExpect(model().attribute("taskId" , notNullValue()));
	
	}
	
	@Test
	public void employeeAccomplishEmptyPostTest()  throws Exception {
		
		this.mockMvc.perform(post("/crm/employeeTask/accomplish"))		
		.andExpect(status().isOk())
		.andExpect(view().name("crm/employeeTask/accomplish"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/employeeTask/accomplish.jsp"))
		.andExpect(model().attribute("taskId" , notNullValue()));
	
	}
	
	
	//Configuration
	
		private HandlerExceptionResolver exceptionResolver() {
			
	        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
	 
	        Properties exceptionMappings = new Properties();
	 
	        exceptionMappings.put("java.lang.Exception", "error/error");
	        exceptionMappings.put("java.lang.RuntimeException", "error/error");
	 
	        exceptionResolver.setExceptionMappings(exceptionMappings);
	 
	        Properties statusCodes = new Properties();
	 
	        statusCodes.put("error/404", "404");
	        
	        exceptionResolver.setStatusCodes(statusCodes);
	 
	        return exceptionResolver;
	    }
	 
		 
		    private LocalValidatorFactoryBean validator() {
		        return new LocalValidatorFactoryBean();
		    }
		 
		    private ViewResolver viewResolver() {
		    	
		        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		 
		        viewResolver.setViewClass(JstlView.class);
		        viewResolver.setPrefix("/WEB-INF/view/");
		        viewResolver.setSuffix(".jsp");
		 
		        return viewResolver;
		    }
}
