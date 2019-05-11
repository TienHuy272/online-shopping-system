package com.fa.mock.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.common.Constant;
import com.fa.mock.dao.UserDAO;
import com.fa.mock.model.UserSystem;

@Repository("userDAO")
@Transactional
public class UserDAOImpl extends AbstractGenricDAOImpl<UserSystem> implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserSystem login(UserSystem userSystem) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(Constant.LOGIN_ADMIN);
		query.setString("userName", userSystem.getUserName());
		query.setString("password", userSystem.getPassword());
		return (UserSystem) query.uniqueResult();
	}

	@Override
	public String getUserRole() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(Constant.GET_USER_ROLE);
		return (String) query.uniqueResult();
	}
}
