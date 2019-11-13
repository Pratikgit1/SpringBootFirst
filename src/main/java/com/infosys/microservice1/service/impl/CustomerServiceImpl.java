package com.infosys.microservice1.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.microservice1.entity.Customer;
import com.infosys.microservice1.repository.CustomerRepository;
import com.infosys.microservice1.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer CreateCustomer(Customer customer) {
		// TODO Auto-generated method stub

		customerRepository.save(customer);

	

         return customer;
	}

	@Override
	public Map<String, String> DeleteCustomer(long customer_id) {
		// TODO Auto-generated method stub
		Map<String,String>  deleteStatus = new HashMap<String, String>();
		customerRepository.deleteById(customer_id);
		deleteStatus.put("status", "success");
		return deleteStatus;
	}

	@Override
	public Optional<Customer> getCustomer(long customer_id) {
		// TODO Auto-generated method stub
		Optional<Customer> getcustomer=customerRepository.findById(customer_id);
		//Iterable<Customer> getcustomer1=customerRepository.findAll();
		
		return getcustomer;
	}

}
