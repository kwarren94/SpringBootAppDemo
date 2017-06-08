package com.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.qa.domains.Customer;
import com.qa.services.CustomerService;

@SpringBootApplication
@ComponentScan({"com.qa.domains", "com.qa.services", "com.qa.repositories"})
@EntityScan("com.qa.domains")
public class FirstSpringBootApplication implements CommandLineRunner{

	
	//injecting service in as this what the client connects to
	@Autowired
	private CustomerService customerService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Customer c1 = new Customer();
		c1.setId(2);
		c1.setName("Bob");
		c1.setEmail("bob@email.com");
		c1.setPassword("5862");
		customerService.createCustomerRecord(c1);
		
	//System.out.println(customerService.updateCustomerRecord(1, "new@gmail.com")+ " record updated!");
		
		//System.out.println(customerService.getAllCustomers());
		
		System.out.println(customerService.getCustomersByName("ka"));
		
	}
}
