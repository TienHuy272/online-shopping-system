package com.fa.mock.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.CustomerDAO;
import com.fa.mock.model.Customer;
import com.fa.mock.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl  implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public Customer login(Customer customer) {
		return customerDAO.login(customer);
	}
	
	@Override
	public Serializable register(Customer customer) {
		return customerDAO.register(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		 customerDAO.update(customer);
	}

}
