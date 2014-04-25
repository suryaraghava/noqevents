package com.noq.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noq.domain.Logindetails;
import com.noq.domain.User;

@Repository("authenticateDao")
public class AuthenticationDaoImpl implements AuthenticationDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
		@SuppressWarnings("unchecked")
	List<User> userList = sessionfactory.getCurrentSession().createSQLQuery("select * from user where username='"+username+"' and password='"+password+"'").addEntity(Logindetails.class).list();
	if(!userList.isEmpty()){
		flag = true;
	}
	else
	{
		flag = false;
	}
		}
		catch(Exception e){
			
		}
		finally{
			if(!sessionfactory.isClosed())
				sessionfactory.close();
		}
		return flag;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
	

}
