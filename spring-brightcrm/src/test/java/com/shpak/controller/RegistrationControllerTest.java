package com.shpak.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.shpak.persistence.model.User;
import com.shpak.persistence.service.UserService;
import com.shpak.utils.InputDBValidator;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@Mock
	private UserService userServiceMock;
	
	@Mock
	private PasswordEncoder passwordEncoderMock;
	
	@Mock
	private InputDBValidator inputDBValidatorMock;
	
	@InjectMocks
	private RegistrationController registrationController;
	
	private MockMvc mockMvc;
	

	@Before
    public void setup() {

        // Setup Spring test in standalone mode
		 mockMvc = MockMvcBuilders.standaloneSetup(registrationController)
				 	.setHandlerExceptionResolvers(exceptionResolver())
	                .setValidator(validator())
	                .setViewResolvers(viewResolver())
	                .build();
    }
	
	@Test
	public void registrationGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/registration"))
		.andExpect(status().isOk())
		.andExpect(view().name("registration"))
		.andExpect(forwardedUrl("/WEB-INF/view/registration.jsp"))
		.andExpect(model().attribute("userForm" , notNullValue()));
			
	}
	
	@Test
	public void registrationEmptyPostTest()  throws Exception {
		
		this.mockMvc.perform(post("/registration"))
		.andExpect(status().isOk())
		.andExpect(view().name("registration"))
		.andExpect(forwardedUrl("/WEB-INF/view/registration.jsp"))
		.andExpect(model().attribute("userForm" , notNullValue()))
		.andExpect(model().errorCount(5));
			
	}
	
	@Test
	public void registrationPostTest()  throws Exception {
		
		when(inputDBValidatorMock.validateUser(Matchers.any(User.class))).thenReturn("ok");
		when(passwordEncoderMock.encode(Matchers.anyString())).thenReturn("hashed");
		
		this.mockMvc.perform(post("/registration")
		.param("username", "username")
		.param("password", "password")
		.param("fullname", "fullname")
		.param("email", "email@email")
		.param("phonenumber", "phonenumber")
		.param("position", "position"))
		.andExpect(status().isOk())
		.andExpect(view().name("registrationSuccess"))
		.andExpect(forwardedUrl("/WEB-INF/view/registrationSuccess.jsp"))
		.andExpect(model().attribute("userForm" , notNullValue()))
		.andExpect(model().attribute("userForm" , hasProperty("password", is ("hashed")) ));
			
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
	
	
	
