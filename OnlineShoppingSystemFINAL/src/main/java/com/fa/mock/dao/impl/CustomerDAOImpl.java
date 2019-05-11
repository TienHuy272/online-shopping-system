package com.fa.mock.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.abstractdao.AbstractGenricDAOImpl;
import com.fa.mock.common.Constant;
import com.fa.mock.dao.CustomerDAO;
import com.fa.mock.model.Customer;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends AbstractGenricDAOImpl<Customer> implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @param customer
	 * @return Customer Method get and authenticate customer
	 */
	@Override
	public Customer login(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(Constant.LOGIN_CUSTOMER);
		query.setString("userName", customer.getUserName());
		query.setString("password", customer.getPassword());
		return (Customer) query.uniqueResult();
	}

	/**
	 * @param customer
	 * @return id customer
	 */
	@Override
	public Serializable register(Customer customer) {
		return sessionFactory.getCurrentSession().save(customer);
	}

}
