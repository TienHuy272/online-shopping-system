package com.fa.mock.service;

import java.io.Serializable;

import com.fa.mock.model.Customer;

public interface CustomerService {
	/**
	 * @param customer
	 * @return Customer Method get and authenticate customer
	 */
	public Customer login(Customer customer);

	/**
	 * @param customer
	 *            Method Update Customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * @param customer
	 * @return boolean Register Customer
	 */
	public Serializable register(Customer customer);

}
