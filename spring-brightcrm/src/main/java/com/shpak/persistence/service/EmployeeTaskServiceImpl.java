package com.shpak.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shpak.persistence.model.EmployeeTask;
import com.shpak.persistence.repository.EmployeeTaskRepository;

@Service
public class EmployeeTaskServiceImpl implements EmployeeTaskService {

	@Autowired
	private EmployeeTaskRepository employeeTaskRepository;
	
	@Override
	public void addEmployeeTask(EmployeeTask task) {
		
		employeeTaskRepository.saveAndFlush(task);

	}
	
	@Override
	public List<EmployeeTask> findByEmployeeFullname(String employeeFullname){
		
		List<EmployeeTask> taskList = employeeTaskRepository.findByEmployeeFullname(employeeFullname);
		List<EmployeeTask> userTask = new ArrayList<>();
		for (EmployeeTask task:taskList){
			if (task.getActive().equals(true)){
				userTask.add(task);
			}
		}
		return userTask;
		
	}

	@Override
	public EmployeeTask findOne(Long id){
		
		return employeeTaskRepository.findOne(id);
		
	}
}
