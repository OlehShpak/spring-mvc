package com.shpak.persistence.model;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customers")
@XmlRootElement(name = "customer")
public class Customer {
	
	@Id  
	@GeneratedValue 
	private Long id; 
	
	@Column(name = "customer_shortname")
	@NotEmpty(message = "Please enter customer short name")
	@Size(min = 0, max = 30, message = "Short name length must be not longer than 30")
	private String shortname;
	
	@Column(name = "customer_fullname")
	@NotEmpty(message = "Please enter customer full name")
	@Size(min = 0, max = 40, message = "Full name length must be not longer than 40")
	private String fullname;
	
	@Email(message="Plz input valid email address")
	@Column(name = "customer_email")
	@NotEmpty(message = "Please enter customer email address")
	@Size(min = 0, max = 30, message = "Email length must be not longer than 30")
	private String email;
	
	@Column(name = "customer_phonenumber")
	@NotEmpty(message = "Please enter customer phone number")
	@Size(min = 0, max = 30, message = "Phonenumber length must be not longer than 30")
	private String phonenumber;
	
	@Column(name = "customer_contactperson")
	@NotEmpty(message = "Please enter customer contact person name")
	@Size(min = 0, max = 40, message = "Contact person name length must be not longer than 40")
	private String contactperson;
	
	@NotEmpty(message = "Please enter some info about customer")
	@Size(min = 0, max = 50, message = "Infoe length must be not longer than 50")
	private String info;
	
	@Column(name = "address_country")
	@NotEmpty(message = "Please enter country")
	@Size(min = 0, max = 30, message = "Country length must be not longer than 30")
    private String country;
	
	@Column(name = "address_zip")
	@NotEmpty(message = "Please enter zip")
	@Size(min = 0, max = 30, message = "Zip length must be not longer than 30")
    private String zip;
	
	@Column(name = "address_city")
	@NotEmpty(message = "Please enter city")
	@Size(min = 0, max = 30, message = "City length must be not longer than 30")
    private String city;
	
	@Column(name = "address_street")
	@NotEmpty(message = "Please enter street and house number")
	@Size(min = 0, max = 30, message = "Street length must be not longer than 30")
    private String street;
	
	@OneToMany(mappedBy="customer")
	private Collection<Deal> deals;
	
	
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	@XmlTransient
	public Collection<Deal> getDeals() {
		return deals;
	}
	public void setDeals(Collection<Deal> deals) {
		this.deals = deals;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", shortname=" + shortname
				+ ", fullname=" + fullname + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", contactperson="
				+ contactperson + ", info=" + info + ", country=" + country
				+ ", zip=" + zip + ", city=" + city + ", street=" + street + "]";
	}

}
