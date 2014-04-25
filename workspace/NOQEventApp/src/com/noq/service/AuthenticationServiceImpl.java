package com.noq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.noq.dao.AuthenticationDAO;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired 
	AuthenticationDAO authServiceDao;
	
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(authServiceDao.login(username, password))
			flag = true;
		
		return flag;
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
