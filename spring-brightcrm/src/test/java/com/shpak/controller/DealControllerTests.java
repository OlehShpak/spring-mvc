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

import com.shpak.persistence.service.DealService;

@RunWith(MockitoJUnitRunner.class)
public class DealControllerTests {
	
	@Mock
	private DealService dealServiceMock;
	
	@InjectMocks
	private DealController dealController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {

        // Setup Spring test in standalone mode
		 mockMvc = MockMvcBuilders.standaloneSetup(dealController)
				 	.setHandlerExceptionResolvers(exceptionResolver())
	                .setValidator(validator())
	                .setViewResolvers(viewResolver())
	                .build();
	}
	
	@Test
	public void dealAddGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/add.jsp"))
		.andExpect(model().attribute("dealForm" , notNullValue()));
			
	}
	
	@Test
	public void dealAddEmptyPostTest() throws Exception {
		
		this.mockMvc.perform(post("/crm/deal/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/add.jsp"))
		.andExpect(model().attribute("dealForm" , notNullValue()))
		.andExpect(model().errorCount(4));
		
	}
	
	@Test
	public void dealAddPostTest() throws Exception {
		
		this.mockMvc.perform(post("/crm/deal/add")
		.param("description", "description")
		.param("totalprice", "String value in BigDecimal field")
		.param("employeeName", "employeeName")
		.param("customerShortname", "customerShortname"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/add.jsp"))
		.andExpect(model().attribute("dealForm" , notNullValue()))
		.andExpect(model().errorCount(1))
		.andExpect(model().attributeHasFieldErrors("dealForm", "totalprice")); 
		
	}
	
	@Test
	public void dealDeleteGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/delete"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/delete"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/delete.jsp"))
		.andExpect(model().attribute("dealId" , notNullValue()));
			
	}

	@Test
	public void DealDeletePostTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/delete"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/delete"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/delete.jsp"))
		.andExpect(model().attribute("dealId" , notNullValue()));
			
	}
	
	@Test
	public void dealSearchByCreatedDateGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/searchByCreatedDate"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/searchByCreatedDate"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/searchByCreatedDate.jsp"))
		.andExpect(model().attribute("createdDate" , notNullValue()));
			
	}
	
	@Test
	public void dealSearchByCreatedDatePostTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/searchByCreatedDate"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/searchByCreatedDate"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/searchByCreatedDate.jsp"))
		.andExpect(model().attribute("createdDate" , notNullValue()));
			
	}
	
	
	@Test
	public void dealSearchByDeadlineGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/searchByDeadline"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/searchByDeadline"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/searchByDeadline.jsp"))
		.andExpect(model().attribute("deadline" , notNullValue()));
			
	}
	
	@Test
	public void dealSearchByDeadlinePostTest()  throws Exception {
		
		this.mockMvc.perform(get("/crm/deal/searchByDeadline"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/deal/searchByDeadline"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/deal/searchByDeadline.jsp"))
		.andExpect(model().attribute("deadline" , notNullValue()));
			
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
	
