package com.noq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.noq.dao.EventsDAO;
import com.noq.domain.Events;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EventServiceImpl implements EventService{

	@Autowired
	EventsDAO eventDao;
	
	@Override
	public boolean addEvent(Events events) {
		// TODO Auto-generated method stub
		boolean flag = eventDao.createEvent(events);
		return flag;
	}

	@Override
	public List<Events> getEvents() {
		// TODO Auto-generated method stub
		System.out.println("in event service");
		List<Events> events = eventDao.getEvents();
		return events;
	}
	
	@Override
	public Events getEvents(String id) {
		// TODO Auto-generated method stub
		System.out.println("in event service");
		Events events = eventDao.getEvents(id);
		return events;
	}
	

}
