package com.infosys.microservice1.repository;

import org.springframework.data.repository.CrudRepository;

import com.infosys.microservice1.entity.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, Long> {

}
