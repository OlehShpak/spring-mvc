package com.shpak.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.Customer;

@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Modifying
    @Transactional
    @Query("delete from Customer c where c.shortname = ?1")
    void deleteByShortname(String shortname);
	
	List<Customer> findByShortname(String shortname);
	
	@Modifying
    @Transactional
	@Query(value = "SELECT CUSTOMER_SHORTNAME FROM CUSTOMERS ORDER BY CUSTOMER_SHORTNAME", nativeQuery = true)
	List<String> getAllCustomersShortname();
	
}
