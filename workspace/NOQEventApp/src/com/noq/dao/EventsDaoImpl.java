package com.noq.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noq.domain.Events;


@Repository("eventDao")
public class EventsDaoImpl implements EventsDAO{

	@Autowired
	private SessionFactory sessionfactory;
	

	@Override
	public boolean createEvent(Events events) {
		boolean flag = false;
		try{
		sessionfactory.getCurrentSession().saveOrUpdate(events);
		flag = true;
		}
		catch(Exception e){
			flag  = false;
			e.printStackTrace();
		}
	
	finally{
		if(!sessionfactory.isClosed())
			sessionfactory.close();
	}
		return flag;
	}

	@Override
	public List<Events> getEvents() {
		List<Events> eventslist=null;
		try{
		System.out.println("in get events method");
		
		eventslist= sessionfactory.getCurrentSession()
				.createSQLQuery("select * from events").addEntity(Events.class).list();
		System.out.println(eventslist);
		System.out.println(eventslist.get(0).getEventtitle());
		
	}
	catch(Exception e){
		
	}
	finally{
		if(!sessionfactory.isClosed())
			sessionfactory.close();
	}
		return eventslist;
	}
	@Override
	public Events getEvents(String id) {
		Events eventslist = null;
		try{
		System.out.println("in get events method");
		
		 eventslist=(Events) sessionfactory.getCurrentSession()
				.createSQLQuery("select * from events where eventid="+id).addEntity(Events.class).uniqueResult();
		
		System.out.println(eventslist.getEventtitle());
		}
		catch(Exception e){
			
		}
		finally{
			if(!sessionfactory.isClosed())
				sessionfactory.close();
		}
			
		return eventslist;
	}
	
}
