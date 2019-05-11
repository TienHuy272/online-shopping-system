package com.fa.mock.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fa.mock.model.Customer;
import com.fa.mock.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/springmvc-servlet.xml"})
public class CustomerDAOTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void testNotNull() {
		assertNotNull(customerService);
	}
	
	@Test
	public void loginTest() {
		Customer customer = new Customer();
		customer.setUserName("tienhuy");
		customer.setPassword("123");
		assertNotNull(customerService.login(customer));
	}
	
//	@Test
//	public void registerTest() {
//		Customer customer = new Customer();
//		customer.setUserName("huynt");
//		customer.setPassword("123456");
//		customer.setFirstName("Huy");
//		customer.setLastName("Nguyen");
//		assertTrue(customerService.register(customer));
//	}
}
