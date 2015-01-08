package com.shpak.persistence.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="employee_tasks")
public class EmployeeTask {
	
	@Id  
	@GeneratedValue
	@Column(name="task_id")
	private Long id;
	
	@Column(name="task_description")
	@NotEmpty(message="Please input task")
	@Size(min = 0, max = 250, message = "Task description must be not longer than 250")
	private String description;
	
	@NotEmpty(message="Please input employee full name")
	@Size(min = 0, max = 40, message = "Employee full name name length must be not longer than 40")
	private String employeeFullname;
	
	@Column(name="task_added_by")
	private String addedBy;
	
	@Column(name="task_created")
	private Date createdDate;
	
	@Column(name="task_active")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeFullname() {
		return employeeFullname;
	}

	public void setEmployeeFullname(String employeeFullname) {
		this.employeeFullname = employeeFullname;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Employee task [id=" + id + description
				+ ", employeeFullname=" + employeeFullname + ", added by="
				+ addedBy + ", createdDate=" + createdDate + "]";
	}

	
	
}
