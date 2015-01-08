package com.shpak.persistence.service;

import java.util.List;

import com.shpak.persistence.model.EmployeeTask;

public interface EmployeeTaskService {
	
	void addEmployeeTask(EmployeeTask task);
	
	List<EmployeeTask> findByEmployeeFullname(String employeeFullname);
	
	EmployeeTask findOne(Long id);
	
}
