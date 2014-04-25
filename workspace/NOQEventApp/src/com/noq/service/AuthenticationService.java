package com.noq.service;

import com.noq.domain.User;

public interface AuthenticationService {
	public User login(String username, String password);
	public void logout();

}
