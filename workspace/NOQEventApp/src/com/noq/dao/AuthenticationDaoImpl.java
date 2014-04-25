package com.noq.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noq.domain.User;

@Repository("authenticateDao")
public class AuthenticationDaoImpl implements AuthenticationDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		boolean flag = false;
		try{
		@SuppressWarnings("unchecked")
	List<User> userList = sessionfactory.getCurrentSession().createSQLQuery("select * from user where username='"+username+"' and password='"+password+"'").addEntity(User.class).list();
	if(!userList.isEmpty()){
		user = userList.get(0);
	}
	
		}
		catch(Exception e){
			
		}
		finally{
			if(!sessionfactory.isClosed())
				sessionfactory.close();
		}
		return user;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
	

}
