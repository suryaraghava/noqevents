package com.noq.dao;

import java.util.List;

import com.noq.domain.User;

public interface UserDao {
public void saveUser ( User user );
public List<User> getUser();
}
