package com.fa.mock.dao;

import com.fa.mock.model.UserSystem;

public interface UserDAO extends IGenericDAO<UserSystem>{
	public UserSystem login(UserSystem userSystem);
	public String getUserRole();
}
