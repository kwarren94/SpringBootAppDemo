package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.domains.Customer;
import com.qa.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	// Add business methods
	
	public Customer createCustomerRecord(Customer c) {
		
		
		return customerRepository.save(c);
	}
	
	//update email
	public int updateCustomerRecord(int id, String email) {
		
		return customerRepository.updateEmailById(id, email);
	}
	
	public Iterable<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}
	
	public Iterable<Customer> getCustomersByName(String name) {
		return customerRepository.getCustomersByName(name);
	}
	
}
