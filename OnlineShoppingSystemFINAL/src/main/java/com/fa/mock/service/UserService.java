package com.fa.mock.service;

import com.fa.mock.model.UserSystem;

public interface UserService {
	
	public UserSystem login(UserSystem userSystem);
	
	public void updateUserSystem(UserSystem userSystem);
	
	public String getUserRole();
}
