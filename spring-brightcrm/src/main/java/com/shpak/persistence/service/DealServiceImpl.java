package com.shpak.persistence.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shpak.persistence.model.Deal;
import com.shpak.persistence.repository.DealRepository;

@Service
public class DealServiceImpl implements DealService {

	@Autowired
	private DealRepository dealRepository;
	
	
	@Override
	public void addDeal(Deal deal) {
		dealRepository.saveAndFlush(deal);

	}
	
	@Override
	public void deleteById(Long id){
		dealRepository.deleteById(id);
	 }
	
	@Override
	public List<Deal> findByCreatedDateBetween(Date from, Date to) {
		
		return dealRepository.findByCreatedDateBetween(from, to);
	}

	@Override
	public List<Deal> findByDeadlineBetween(Date from, Date to) {
		
		return dealRepository.findByDeadlineBetween(from, to);
	}

}
