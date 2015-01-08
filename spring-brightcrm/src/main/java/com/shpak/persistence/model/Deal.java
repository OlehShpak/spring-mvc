package com.shpak.persistence.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="deals")
public class Deal {
	
	@Id  
	@GeneratedValue
	@Column(name="deal_id")
	private Long id; 
	
	@Column(name = "deal_description")
	@NotEmpty(message = "Please input deal description")
	@Size(min = 0, max = 250, message = "Deal description must be not longer than 250")
	private String description;
	
	@Column(name="deal_totalprice", precision = 13, scale = 2)
	@Digits(integer=13, fraction=2, message="Please input correct total price")
	@NotNull(message=" Please input total price")
	@Range(min = 0, max = 1000000000, message = "Invalid range of total price")
	private BigDecimal totalprice;
	
	@Column(name="deal_created")
	private Date createdDate;
	
	@Column(name="deal_deadline")
	private Date deadline;
	
	@Column(name="deal_employee_name")
	@NotEmpty(message = "Please input responsible employee")
	private String employeeName;
	
	@ManyToOne
	private Customer customer;
	
	@Column(name="deal_customer_shortname")
	@NotEmpty(message = "Please input customer name")
	private String customerShortname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getCustomerShortname() {
		return customerShortname;
	}

	public void setCustomerShortname(String customerShortname) {
		this.customerShortname = customerShortname;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", description=" + description
				+ ", totalprice=" + totalprice + ", createdDate=" + createdDate
				+ ", deadline=" + deadline + ", employeeName=" + employeeName
				+ ", customerShortname=" + customerShortname + "]";
	}

	

}
