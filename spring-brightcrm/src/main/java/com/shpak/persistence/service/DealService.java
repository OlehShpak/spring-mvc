package com.shpak.persistence.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.shpak.persistence.model.Deal;

public interface DealService {

	void addDeal(Deal deal);
	
	void deleteById(Long id);
	
	List<Deal> findByCreatedDateBetween(Date from, Date to);
	
	List<Deal> findByDeadlineBetween(Date from, Date to);
	
	List<Deal> findBigDeals(BigDecimal minprice);
	
	List<Deal> employeeEfficiency(String fullname);
	
}
