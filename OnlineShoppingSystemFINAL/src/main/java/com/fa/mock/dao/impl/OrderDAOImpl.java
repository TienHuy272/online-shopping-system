package com.fa.mock.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.abstractdao.AbstractGenricDAOImpl;
import com.fa.mock.dao.OrderDAO;
import com.fa.mock.model.Orders;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl extends AbstractGenricDAOImpl<Orders> implements OrderDAO{
	
}
