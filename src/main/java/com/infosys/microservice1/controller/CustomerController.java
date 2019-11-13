package com.infosys.microservice1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infosys.microservice1.entity.Customer;
import com.infosys.microservice1.repository.CustomerRepository;
import com.infosys.microservice1.service.CustomerService;

@RestController
@RequestMapping("/customer")

public class CustomerController {
			
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public Customer CreateCustomer(@Valid @RequestBody Customer custm) 
	{ 
		
		System.out.println("customer is="+custm);
		
		
		Customer customer =customerService.CreateCustomer(custm);
		
			
		
		return customer;
		
	}
    
	@DeleteMapping("/{id}")
	public Map<String,String> DeleteCustomer(@PathVariable(value = "id")  long customer_id)
	{
		Map<String,String>  deleteStatus = new HashMap<String, String>();
		deleteStatus=customerService.DeleteCustomer(customer_id);
		return deleteStatus;
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomer(@PathVariable(value = "id") long customer_id)
	{
		
		Optional<Customer> getcustomer=customerService.getCustomer(customer_id);
		//Iterable<Customer> getcustomer1=customerRepository.findAll();
		
		return getcustomer;
	}
	
	
}
