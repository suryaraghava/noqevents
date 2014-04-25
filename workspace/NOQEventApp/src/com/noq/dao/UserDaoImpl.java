package com.noq.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noq.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveUser(User user) {
		try{
		sessionfactory.getCurrentSession().saveOrUpdate(user);
		}
		catch(Exception e){
			
		}
		finally{
			if(!sessionfactory.isClosed())
				sessionfactory.close();
		}
	}

	@Override
	public List<User> getUser() {
		List<User> userlist = null;
		try{
		
		userlist = sessionfactory.getCurrentSession()
				.createCriteria(User.class).add(Expression.eq("id",1)).list();
	}
	catch(Exception e){
		
	}
	finally{
		if(!sessionfactory.isClosed())
			sessionfactory.close();
	}
		return userlist;
	}

}
