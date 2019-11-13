package com.infosys.microservice1.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.microservice1.entity.Customer;
import com.infosys.microservice1.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void testCreateCustomer() {
		
		Customer cs=new Customer();
		cs.setFirstname("jtesting");
		cs.setLastname("lastname");
		cs.setEmailid("testing@gmail.com");
		cs.setPhonenumber(9716266262L); 
		Date d=new Date();
		cs.setDob(d); 
		System.out.println("pratik="+customerService);
		Customer css=customerService.CreateCustomer(cs);
		assertTrue(css.getCustomer_id()>0);

	}

	@Test
	public void testDeleteCustomer() {	
		Map<String,String>  deleteStatus = new HashMap<String, String>();	
		deleteStatus=customerService.DeleteCustomer(15);
		assertNotEquals(deleteStatus.isEmpty(), true);
	}

	@Test
	public void testGetCustomer() {
		Optional<Customer> getC=customerService.getCustomer(12);
		assertEquals(getC.isPresent(), true);
	}

}
