package com.shpak.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shpak.persistence.model.Customer;
import com.shpak.persistence.service.CustomerService;
import com.shpak.utils.InputDBValidator;
import com.shpak.utils.StringParamHolder;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private InputDBValidator inputDBValidator;
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
	    dataBinder.setDisallowedFields("id");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping(value = "/crm/customer/add", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		
		List<String> customerList = customerService.getAllCustomersShortname();
		model.addAttribute("customerList", customerList);
		
		Customer addCustomer = new Customer();
		model.addAttribute("addCustomer", addCustomer);
		LOGGER.info("Customer list is uploaded and with addCustomer is added to model");
		
		return "crm/customer/add";
	}

	@RequestMapping(value = "/crm/customer/add", method = RequestMethod.POST)
	public String addCustomer( @Valid @ModelAttribute("addCustomer") Customer addCustomer,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "crm/customer/add";
		} else {

			String validation = inputDBValidator.validateCustomer(addCustomer); 	// make sure that shortname, email or																	
																					// phonenumber doesn't exist
			if (!validation.equals("ok")) { 	
				LOGGER.info("This customer already exists, user has to input new customer");
				
				model.addAttribute("inputError", validation);
				return "crm/customer/add";
			} else {
				LOGGER.info("This customer is new, hence he will be saved");
				
				customerService.addCustomer(addCustomer); 							
				return "redirect:/crm/customer/searchByShortname";
			}
		}
	}

	// Delete customer

	@RequestMapping(value = "/crm/customer/delete", method = RequestMethod.GET)
	public String deleteCustomer(Model model) {
		
		StringParamHolder shortname = new StringParamHolder();
		List<String> customerList = customerService.getAllCustomersShortname();
		model.addAttribute("shortname", shortname);
		model.addAttribute("customerList", customerList);
		LOGGER.info("Customer list is uploaded and with attribute shortname for delete fuction is added to model");
		
		return "crm/customer/delete";
	}

	@RequestMapping(value = "/crm/customer/delete", method = RequestMethod.POST)
	public String deleteCustomer( @ModelAttribute("shortname") StringParamHolder shortname, Model model) {

		List<String> customerList = customerService.getAllCustomersShortname();
		model.addAttribute("customerList", customerList);
		String deleteMessage = customerService.deleteByShortname(shortname.getParameter());
		model.addAttribute("deleteMessage", deleteMessage);
		LOGGER.info("Customer deleted by shortname");
		
		return "crm/customer/delete";

	}

	// Search customer by shortname
	
	@RequestMapping(value="/crm/customer/searchByShortnamePV/{customerShortname}")
	public String searchCustomerPV(@PathVariable String customerShortname, Model model){
		
		Customer customer = customerService.findByShortname(customerShortname);
		if (customer != null) {
			model.addAttribute("customer", customer);
			LOGGER.info("This customer exists, hence he is added to model");
			
			return "crm/customer/searchByShortnamePV";
		} else {
			String inputMessage = "Customer doesn't exist";
			model.addAttribute("inputMessage", inputMessage);
			return "crm/customer/searchByShortnamePV";
		}
	}
	
	@RequestMapping(value = "/crm/customer/searchByShortname", method = RequestMethod.GET)
	public String searchCustomer(Model model) {
		
		StringParamHolder shortname = new StringParamHolder();
		model.addAttribute("shortname", shortname);
		LOGGER.info("Customer model.addAttribute shortname for searchByShortname fuction is added to model");
		
		return "crm/customer/searchByShortname";
	}

	@RequestMapping(value = "/crm/customer/searchByShortname", method = RequestMethod.POST)
	public String searchCustomer( @ModelAttribute("shortname") StringParamHolder shortname, Model model) {

		Customer customer = customerService.findByShortname(shortname.getParameter());
		if (customer != null) {
			model.addAttribute("customer", customer);
			LOGGER.info("This customer exists, hence he is added to model");
			
			return "crm/customer/searchByShortname";
		} else {
			String inputMessage = "Customer doesn't exist";
			model.addAttribute("inputMessage", inputMessage);
			return "crm/customer/searchByShortname";
		}
	}

}
