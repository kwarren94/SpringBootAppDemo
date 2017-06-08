package com.qa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.domains.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Modifying
	@Transactional
	//JPA based query (Customer) 
	//c is the instance of the customer i.e table alias
	@Query("UPDATE Customer c set c.email = :email where c.id = :id")
	public int updateEmailById(@Param("id")int id,@Param("email") String email);
	

	// get all customer by name
	// good query to use when searching for books for example
	@Query("SELECT c from Customer c where c.name like %:name%")
	public Iterable<Customer> getCustomersByName(@Param("name") String name);
	
	
	@Query("SELECT c from Customer c where c.email = :email")
	public Customer getCustomerByEmail(@Param("email") String email);
}
