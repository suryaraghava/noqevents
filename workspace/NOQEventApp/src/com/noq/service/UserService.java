package com.noq.service;

import java.util.List;

import com.noq.domain.User;

public interface UserService {
	public void addUser(User user);

	public List<User> getUser();
}
