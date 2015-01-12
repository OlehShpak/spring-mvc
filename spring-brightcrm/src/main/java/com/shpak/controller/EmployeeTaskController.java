package com.shpak.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shpak.persistence.model.EmployeeTask;
import com.shpak.persistence.model.User;
import com.shpak.persistence.service.EmployeeTaskService;
import com.shpak.persistence.service.UserService;
import com.shpak.utils.LongParamHolder;

@Controller
public class EmployeeTaskController {

	@Autowired
	private EmployeeTaskService employeeTaskService;

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
	    dataBinder.setDisallowedFields("id");
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeTaskController.class);

	@RequestMapping(value = "crm/employeeTask/add", method = RequestMethod.GET)
	public String addEmployeeTask(Model model) {
		
		EmployeeTask task = new EmployeeTask();
		model.addAttribute("task", task);
		LOGGER.info("Attribute task added to model");
		
		return "crm/employeeTask/add";
	}

	@RequestMapping(value = "crm/employeeTask/add", method = RequestMethod.POST)
	public String addEmployeeTask( @Valid @ModelAttribute("task") EmployeeTask task,
			BindingResult result, Model model, Principal principal) {
		
		if (result.hasErrors()) {
			return "crm/employeeTask/add";
		} else {
			String addedBy = principal.getName(); // get logged in username
			User user = userService.findByUserName(addedBy);
			task.setAddedBy(user.getFullname());
			task.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
			task.setActive(true);
			
			LOGGER.info("EmployeeTask is ready to be saved");
			
			employeeTaskService.addEmployeeTask(task);
			return "redirect:/crm/employeeTask/viewTasks";
		}
	}

	// View tasks by username

	@RequestMapping(value = "crm/employeeTask/viewTasks", method = RequestMethod.GET)
	public String viewEmployeeTask(Model model, Principal principal) {
		
		String username = principal.getName();
		User user = userService.findByUserName(username);
		List<EmployeeTask> taskList = employeeTaskService.findByEmployeeFullname(user.getFullname());
		model.addAttribute("taskList", taskList);
		LOGGER.info("Attribute taskList added to model");
		
		return "crm/employeeTask/viewTasks";
	}

	// Accomplish task

	@RequestMapping(value = "/crm/employeeTask/accomplish", method = RequestMethod.GET)
	public String accomplishTask(Model model) {
		
		LongParamHolder taskId = new LongParamHolder();
		model.addAttribute("taskId", taskId);
		LOGGER.info("Attribute taskId added to model");
		
		return "crm/employeeTask/accomplish";
	}

	@RequestMapping(value = "/crm/employeeTask/accomplish", method = RequestMethod.POST)
	public String accomplishTask( @ModelAttribute("taskId") LongParamHolder taskId, Model model) {
		
		if (taskId.getParameter() != null) {
			EmployeeTask task = employeeTaskService.findOne(taskId.getParameter());

			if (task != null) {
				task.setActive(false); // update (accomplish) task
				
				LOGGER.info("EmployeeTask exists and ready to be updated");
				
				employeeTaskService.addEmployeeTask(task);
			} else {
				String inputMessage = "Task doesn't exist";
				model.addAttribute("inputMessage", inputMessage);
			}
			return "crm/employeeTask/accomplish";
		} else {
			return "crm/employeeTask/accomplish";
		}
	}

}
