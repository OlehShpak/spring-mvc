package com.shpak.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shpak.persistence.model.User;
import com.shpak.persistence.service.UserService;
import com.shpak.utils.InputDBValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private InputDBValidator inputDBValidator;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String helloController(Model model){
		
		User userForm = new User();
		model.addAttribute("userForm", userForm);
		
		LOGGER.info("Registration form created");
		
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postController(@Valid @ModelAttribute("userForm") User userForm, BindingResult result, Model model){
		
		if(result.hasErrors()){
			return "registration";
		} 
		String validation = inputDBValidator.validateUser(userForm);				//make sure that username, email or
		if (!validation.equals("ok")){												// phonenumber doesn't exist
			model.addAttribute("inputError", validation);
			return "registration";
		} else {
			
		LOGGER.info("Registration data passed validation with 'ok'");
			
		String hashedPassword = passwordEncoder.encode(userForm.getPassword());
		userForm.setPassword(hashedPassword);
		userForm.setEnabled(true);
		userService.addUser(userForm);
		return "registrationSuccess";
		}
	}
	
	
	
}
