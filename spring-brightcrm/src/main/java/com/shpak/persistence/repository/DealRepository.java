package com.shpak.persistence.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.Deal;

@Transactional(readOnly = true)
public interface DealRepository extends JpaRepository<Deal, Long> {
		
	@Modifying
    @Transactional
    @Query("delete from Deal d where d.id = :id")
    void deleteById(@Param("id") Long id);
	
	@Modifying
    @Transactional
    @Query("delete from Deal d where d.customerShortname = :customerShortname")
    void deleteByCustomerShortname(@Param("customerShortname") String customerShortname);
	
	@Modifying
    @Query("select d from Deal d where d.createdDate >= :from and d.createdDate <= :to ")
	List<Deal> findByCreatedDateBetween(@Param("from") Date from, @Param("to") Date to);
	
	@Modifying
    @Query("select d from Deal d where d.deadline >= :from and d.deadline <= :to ")
	List<Deal> findByDeadlineBetween(@Param("from") Date from, @Param("to") Date to);
	
	@Modifying
    @Query("select d from Deal d where d.totalprice >= :minprice ")
	List<Deal> findBigDeals(@Param("minprice") BigDecimal minprice);
	
	@Modifying
    @Query("select d from Deal d where d.employeeName = :userFullname ")
	List<Deal> employeeEfficiency(@Param("userFullname") String fullname);
	
}
