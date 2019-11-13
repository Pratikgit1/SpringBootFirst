package com.infosys.microservice1.service;

import java.util.Map;
import java.util.Optional;

import com.infosys.microservice1.entity.Customer;

public interface CustomerService {

	public Customer CreateCustomer(Customer customer);
	public Map<String,String> DeleteCustomer(long customer_id); 
	public Optional<Customer> getCustomer(long customer_id);
}
