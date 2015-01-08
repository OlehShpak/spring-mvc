package com.shpak.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shpak.persistence.model.Customer;
import com.shpak.persistence.model.Deal;
import com.shpak.persistence.service.CustomerService;
import com.shpak.persistence.service.DealService;
import com.shpak.utils.DateParamHolder;
import com.shpak.utils.LongParamHolder;

@Controller
public class DealController {

	@Autowired
	private DealService dealService;
	
	@Autowired
	private CustomerService customerService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DealController.class);
	
	@RequestMapping(value="crm/deal/add", method=RequestMethod.GET)
	public String addDeal(Model model){
		
		Deal dealForm = new Deal();
		model.addAttribute("dealForm", dealForm);
		LOGGER.info("Attribute dealForm added to model");
		
		return "crm/deal/add";
	}
	
	@RequestMapping(value="crm/deal/add", method=RequestMethod.POST)
	public String addDeal(@Valid @ModelAttribute("dealForm") Deal dealForm, BindingResult result, Model model){
		
		if (result.hasErrors()){
			return "crm/deal/add";
		} else {
			dealForm.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
			Customer customer = customerService.findByShortname(dealForm.getCustomerShortname());
			if (customer!=null){			
				LOGGER.info("Customer exists, deal will be assigned to this customer");
				
				dealForm.setCustomer(customer);
				dealService.addDeal(dealForm);
				return "crm/deal/add";
			} else {
				String inputError = "Customer doesn't exist";
				model.addAttribute("inputError", inputError);
				return "crm/deal/add";
			}
			
		}
	}
	//Delete deal by id
	
		@RequestMapping(value="/crm/deal/delete",method=RequestMethod.GET)
		public String deleteDeal(Model model){
			
			LongParamHolder dealId = new LongParamHolder();
			model.addAttribute("dealId", dealId);
			LOGGER.info("Attribute dealId added to model");
			
			return "crm/deal/delete";
		}
		
		@RequestMapping(value="/crm/deal/delete",method=RequestMethod.POST)
		public String deleteDeal (@ModelAttribute("dealId") LongParamHolder dealId,  Model model ){
			
			dealService.deleteById(dealId.getParameter());			
			LOGGER.info("Deal deleted by id");
			
			return "crm/deal/delete";
				
			}
	
	// Search deal by created date
	
	@RequestMapping(value="crm/deal/searchByCreatedDate", method=RequestMethod.GET)
	public String searchDealByDate(Model model){
		
		DateParamHolder createdDate = new DateParamHolder();
		model.addAttribute("createdDate", createdDate);
		LOGGER.info("Attribute createdDate added to model");
		
		return "crm/deal/searchByCreatedDate";
	}
	
	@RequestMapping(value="/crm/deal/searchByCreatedDate", method=RequestMethod.POST)
	public String searchDealByDate(@ModelAttribute("createdDate") DateParamHolder createdDate,BindingResult result, Model model ){
		
		if (result.hasErrors()){
			return "crm/deal/searchByCreatedDate";
		} else {
		List<Deal> dealList = dealService.findByCreatedDateBetween(createdDate.getFrom(), createdDate.getTo());
		model.addAttribute("dealList", dealList);
		LOGGER.info("Deals are found in custom created date range and added to model");
		
		return "crm/deal/searchByCreatedDate";
	
		}
	}
	
	
	@RequestMapping(value="crm/deal/searchByDeadline", method=RequestMethod.GET)
	public String searchDealByDeadline(Model model){
		DateParamHolder deadline = new DateParamHolder();
		model.addAttribute("deadline", deadline);
		LOGGER.info("Attribute deadline added to model");
		
		return "crm/deal/searchByDeadline";
	}
	
	@RequestMapping(value="/crm/deal/searchByDeadline", method=RequestMethod.POST)
	public String searchDealByDeadline(@ModelAttribute("deadline") DateParamHolder deadline,BindingResult result, Model model ){
		
		if (result.hasErrors()){
			return "crm/deal/searchByDeadline";
		} else {
		List<Deal> dealList = dealService.findByCreatedDateBetween(deadline.getFrom(), deadline.getTo());
		model.addAttribute("dealList", dealList);
		LOGGER.info("Deals are found in custom deadline range and added to model");
		
		return "crm/deal/searchByDeadline";
	
		}
	}
	
    }
	

