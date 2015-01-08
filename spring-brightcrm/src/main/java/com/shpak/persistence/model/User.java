package com.shpak.persistence.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@NotEmpty(message = "Please enter your username")
	@Size(min = 0, max = 30, message = "Username length must be not longer than 30")
	private String username;
	
	
	@Size(min = 6, max = 60, message = "Password length must be between 6 and 20")
	private String password;
	
	
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	
	@NotEmpty(message = "Please enter your full name")
	@Size(min = 0, max = 30, message = "Full name length must be not longer than 30")
	private String fullname;
	
	@Email(message="Please input valid email address")
	@NotEmpty(message = "Please enter your email address")
	@Size(min = 0, max = 30, message = "Email length must be not longer than 30")
	private String email;
	

	@NotEmpty(message = "Please enter your phone number")
	@Size(min = 0, max = 30, message = "Username length must be not longer than 30")
	private String phonenumber;
	
	@NotEmpty(message = "Please enter your position")
	@Size(min = 0, max = 30, message = "Position length must be not longer than 30")
	private String position;
	
	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username+", position="+position
				+ ", enabled=" + enabled + ", userRole=" + userRole
				+ ", fullname=" + fullname + ", email=" + email
				+ ", phonenumber=" + phonenumber + "]";
	}
	
	
	
}