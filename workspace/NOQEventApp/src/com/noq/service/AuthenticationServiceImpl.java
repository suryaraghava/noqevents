package com.noq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.noq.dao.AuthenticationDAO;
import com.noq.domain.User;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired 
	AuthenticationDAO authServiceDao;
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		
		return authServiceDao.login(username, password);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
