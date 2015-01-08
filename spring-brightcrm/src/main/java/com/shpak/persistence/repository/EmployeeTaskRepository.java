package com.shpak.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.EmployeeTask;

@Transactional(readOnly = true)
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask, Long> {
		
	List<EmployeeTask> findByEmployeeFullname(String employeeFullname);
	
}
