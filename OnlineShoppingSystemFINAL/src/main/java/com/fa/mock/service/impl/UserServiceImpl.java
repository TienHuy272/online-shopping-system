package com.fa.mock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.UserDAO;
import com.fa.mock.model.UserSystem;
import com.fa.mock.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserSystem login(UserSystem userSystem) {
		return userDAO.login(userSystem);
	}

	@Override
	public void updateUserSystem(UserSystem userSystem) {
		userDAO.update(userSystem);
	}

	@Override
	public String getUserRole() {
		return userDAO.getUserRole();
	}


}
