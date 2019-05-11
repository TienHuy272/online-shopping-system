package com.fa.mock.dao;

import java.io.Serializable;

import com.fa.mock.genericdao.IGenericDAO;
import com.fa.mock.model.Customer;

public interface CustomerDAO extends IGenericDAO<Customer>{
	
	/**
	 * @param customer
	 * @return Customer 
	 * Method get and authenticate customer 
	 */
	public Customer login(Customer customer);
	
	
	/**
	 * @param customer
	 * @return boolean 
	 * Register Serializable
	 */
	public Serializable register(Customer customer);
} 
