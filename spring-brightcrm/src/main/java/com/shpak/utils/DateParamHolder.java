package com.shpak.utils;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;



public class DateParamHolder {
	
	@NotEmpty
	private Date from ;
	
	@NotEmpty
	private Date to ;
	

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	
	
}
