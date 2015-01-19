package com.shpak.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shpak.persistence.model.Deal;
import com.shpak.persistence.service.DealService;
import com.shpak.utils.LongParamHolder;
import com.shpak.utils.StringParamHolder;

@Controller
public class AnalyticController {
	
	@Autowired
	private DealService dealService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnalyticController.class);
	
	@RequestMapping(value="/crm/analytic/findBigDeals", method = RequestMethod.GET)
	public String findBigDeals(Model model){
		
		LongParamHolder minTotalprice = new LongParamHolder();
		model.addAttribute("minTotalprice", minTotalprice);
		return "crm/analytic/findBigDeals";
	}
	
	@RequestMapping(value="/crm/analytic/findBigDeals", method = RequestMethod.POST)
	public String findBigDeals(@ModelAttribute("minTotalprice") LongParamHolder minTotalprice, Model model){
		
		if (minTotalprice.getParameter() != null) {
		BigDecimal totalprice = new BigDecimal(minTotalprice.getParameter());
		List<Deal> bigDealsList = dealService.findBigDeals(totalprice);
		model.addAttribute("bigDealsList", bigDealsList);
		LOGGER.info("Deals are uploaded and like 'bigDealsList' are added to model");
		
		return "crm/analytic/findBigDeals";
		} else {
		return "crm/analytic/findBigDeals";
		}
	}
	
	@RequestMapping(value="/crm/analytic/employeeEfficiency", method = RequestMethod.GET)
	public String employeeEfficiency(Model model){
		
		StringParamHolder userFullname = new StringParamHolder();
		model.addAttribute("userFullname", userFullname);
		return "crm/analytic/employeeEfficiency";
	}
	
	@RequestMapping(value="/crm/analytic/employeeEfficiency", method = RequestMethod.POST)
	public String employeeEfficiency(@ModelAttribute("userFullname") StringParamHolder userFullname, Model model){
		
		if (userFullname.getParameter()!=null){
		List<Deal> empDealsList = dealService.employeeEfficiency(userFullname.getParameter());
		model.addAttribute("empDealsList", empDealsList);
		LOGGER.info("Deals are uploaded and like 'empDealsList' are added to model");
		
		return "crm/analytic/employeeEfficiency";
		} else {
		return "crm/analytic/employeeEfficiency";
		}
	}

}