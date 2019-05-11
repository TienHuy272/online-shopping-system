package com.fa.mock.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.abstractdao.AbstractGenricDAOImpl;
import com.fa.mock.common.Constant;
import com.fa.mock.dao.OrderDetailsDAO;
import com.fa.mock.model.OrderDetails;

@Repository("orderDetailsDAO")
@Transactional
public class OrderDetailsDAOImpl extends AbstractGenricDAOImpl<OrderDetails> implements OrderDetailsDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insertOrderDetails(OrderDetails orderDetails) {
		boolean check = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(Constant.INSERT_ORDERDETAILS);
			query.setInteger(0, orderDetails.getProductId());
			query.setInteger(1, orderDetails.getOrderId());
			query.setDouble(2, orderDetails.getUnitPrice());
			query.setInteger(3, orderDetails.getQuantity());
			check = query.executeUpdate() > 0;
		} catch(HibernateException e) {
			check = false;
		}
		return check;
	}
	
}
