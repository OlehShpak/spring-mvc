package com.shpak.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Properties;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.shpak.controller.CustomerController;
import com.shpak.persistence.model.Customer;
import com.shpak.persistence.service.CustomerService;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTests {
	
	
	@Mock
	private CustomerService customerServiceMock;
	
	@InjectMocks
	private CustomerController customerController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {

        // Setup Spring test in standalone mode
		 mockMvc = MockMvcBuilders.standaloneSetup(customerController)
				 	.setHandlerExceptionResolvers(exceptionResolver())
	                .setValidator(validator())
	                .setViewResolvers(viewResolver())
	                .build();
    }
	
	@Test
	public void customerAddGetTest()  throws Exception {
		
		String cust1 = "Customer1";
		String cust2 = "Customer2";
		
		 when(customerServiceMock.getAllCustomersShortname()).thenReturn(Arrays.asList(cust1, cust2));
		
		this.mockMvc.perform(get("/crm/customer/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/add.jsp"))
		.andExpect(model().attribute("customerList", hasSize(2)))
		.andExpect(model().attribute("addCustomer" , notNullValue()))
		.andExpect(model().attribute("addCustomer" , hasProperty("shortname", nullValue())));
	
	}
	
	@Test
	public void customerAddEmptyPostTest() throws Exception {
		
		this.mockMvc.perform(post("/crm/customer/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/add.jsp"))
		.andExpect(model().attribute("addCustomer" , notNullValue()))
		.andExpect(model().errorCount(10));
		
	}
	
	@Test
	public void customerAddPostTest() throws Exception {
		
		this.mockMvc.perform(post("/crm/customer/add")
		.param("shortname", "short")
		.param("fullname", "full")	
		.param("email", "email")	//special wrong email format		
		.param("phonenumber", "phonenumber")
		.param("contactperson", "contactperson")
		.param("info", "info")	
		.param("street", "street")	
		.param("city", "city")	
		.param("zip", "zip")	
		.param("country", "country"))	
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/add"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/add.jsp"))
		.andExpect(model().attribute("addCustomer" , notNullValue()))
		.andExpect(model().errorCount(1))
		.andExpect(model().attributeHasFieldErrors("addCustomer", "email"));   //email validation works
		
		
		
	}
	
	@Test
	public void customerDeleteGetTest()  throws Exception {
		
		String cust1 = "Customer1";
		String cust2 = "Customer2";
		
		 when(customerServiceMock.getAllCustomersShortname()).thenReturn(Arrays.asList(cust1, cust2));
		
		this.mockMvc.perform(get("/crm/customer/delete"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/delete"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/delete.jsp"))
		.andExpect(model().attribute("customerList", hasSize(2)))
		.andExpect(model().attribute("shortname" , notNullValue()))
		.andExpect(model().attribute("shortname" , hasProperty("parameter", nullValue())));
	
	}
	
	@Test
	public void customerDeletePostTest() throws Exception {
		
		when(customerServiceMock.deleteByShortname("shortname")).thenReturn("Customer deleted");
		
		this.mockMvc.perform(post("/crm/customer/delete")
		.param("parameter", "shortname"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/delete"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/delete.jsp"))
		.andExpect(model().attribute("shortname" , hasProperty("parameter", is("shortname"))))
		.andExpect(model().attribute("deleteMessage", "Customer deleted" ));
	
	}
	
	@Test
	public void customerFindByShortnameGetTest()  throws Exception {	
		
		this.mockMvc.perform(get("/crm/customer/searchByShortname"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/searchByShortname"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/searchByShortname.jsp"))
		.andExpect(model().attribute("shortname", notNullValue()))
		.andExpect(model().attribute("shortname" , hasProperty("parameter", nullValue())));
	
	}
	
	@Test
	public void customerFindByShortnamePostTest() throws Exception {
		
		Customer customer = new Customer();
		customer.setShortname("shortname");
		customer.setFullname("fullname");
		when(customerServiceMock.findByShortname("shortname")).thenReturn(customer);
		
		this.mockMvc.perform(post("/crm/customer/searchByShortname")
		.param("parameter", "shortname"))
		.andExpect(status().isOk())
		.andExpect(view().name("crm/customer/searchByShortname"))
		.andExpect(forwardedUrl("/WEB-INF/view/crm/customer/searchByShortname.jsp"))
		.andExpect(model().attribute("shortname" , hasProperty("parameter", is("shortname"))))
		.andExpect(model().attribute("customer", hasProperty("fullname", is("fullname"))));
	
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
