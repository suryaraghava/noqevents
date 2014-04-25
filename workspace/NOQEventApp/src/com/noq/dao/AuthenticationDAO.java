package com.noq.dao;

import com.noq.domain.User;

public interface AuthenticationDAO {

	public User login(String username, String password);
	public void logout();
}
