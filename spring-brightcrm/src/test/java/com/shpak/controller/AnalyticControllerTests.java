package com.shpak.controller;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.shpak.persistence.model.Deal;
import com.shpak.persistence.service.DealService;

@RunWith(MockitoJUnitRunner.class)
public class AnalyticControllerTests {
	
	@Mock
	private DealService dealServiceMock;
	
	@InjectMocks
	private AnalyticController analyticController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {

        // Setup Spring test in standalone mode
		 mockMvc = MockMvcBuilders.standaloneSetup(analyticController)
				 	.setHandlerExceptionResolvers(exceptionResolver())
	                .setValidator(validator())
	                .setViewResolvers(viewResolver())
	                .build();
    }
	
	@Test
	public void findBigDealsGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/analytic/findBigDeals"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/analytic/findBigDeals"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/analytic/findBigDeals.jsp"))
		.andExpect(model().attribute("minTotalprice" , notNullValue()));
			
	}
	
	@Test
	public void findBigDealsPostTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/analytic/findBigDeals"))		
		.andExpect(status().isOk())
		.andExpect(view().name("crm/analytic/findBigDeals"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/analytic/findBigDeals.jsp"))
		.andExpect(model().attribute("minTotalprice" , notNullValue()));
			
	}
	
	@Test
	public void employeeEfficiencyGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/analytic/employeeEfficiency"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/analytic/employeeEfficiency"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/analytic/employeeEfficiency.jsp"))
		.andExpect(model().attribute("userFullname" , notNullValue()));
			
	}
	
	@Test
	public void employeeEfficiencyPostTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/analytic/employeeEfficiency")
		.param("parameter", "employee"))		
		.andExpect(status().isOk())
		.andExpect(view().name("crm/analytic/employeeEfficiency"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/analytic/employeeEfficiency.jsp"))
		.andExpect(model().attribute("userFullname" , notNullValue()));
		
			
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