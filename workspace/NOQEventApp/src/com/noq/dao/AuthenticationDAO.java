package com.noq.dao;

public interface AuthenticationDAO {

	public boolean login(String username, String password);
	public void logout();
}
