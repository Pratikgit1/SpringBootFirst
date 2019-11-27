package com.infosys.microservice1.service.impl;


import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.microservice1.entity.Customer;
import com.infosys.microservice1.repository.CustomerRepository;
import com.infosys.microservice1.service.CustomerService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceimpl;
	
	@Mock
	CustomerRepository customerRepository;
	
	 @Before
	    public void setUp() throws Exception {
		
	         MockitoAnnotations.initMocks(this);
	        
	    } 
	@Test
	public void testCreateCustomer() {
		
		Customer cs=new Customer();
		cs.setFirstname("jtesting");
		cs.setLastname("lastname"); 
		cs.setEmailid("testing@gmail.com");
		cs.setPhonenumber(9716266262L); 
		Date d=new Date();
		cs.setDob(d); 
			
		Mockito.when(customerRepository.save(cs)).thenReturn(cs);
		
		Customer css=customerServiceimpl.CreateCustomer(cs); 
		
		System.out.println("dummy recordreturn"+css);
		assertEquals(css.getEmailid(),"testing@gmail.com");

	}

	@Test
	public void testDeleteCustomer() {	
	
		Map<String,String>  deleteStatus = new HashMap<String, String>();	
		
		deleteStatus=customerServiceimpl.DeleteCustomer(14);
		assertNotEquals(deleteStatus.isEmpty(), true);
	}

	@Test
	public void testGetCustomer() {
		Customer cs=new Customer();
		cs.setFirstname("jtesting");
		cs.setLastname("lastname"); 
		cs.setEmailid("testing@gmail.com");
		cs.setPhonenumber(9716266262L); 
		Date d=new Date();
		cs.setDob(d); 
		
		Mockito.when(customerRepository.findById(14L)).thenReturn((Optional.of(cs)));
		Optional<Customer> getC=customerServiceimpl.getCustomer(14);
		System.out.println("get ="+getC);
		assertEquals(getC.isPresent(), true);
	}

}
