package com.noq.dao;

import java.util.List;

import com.noq.domain.Eventcategory;
import com.noq.domain.Events;

public interface EventsDAO {
	public boolean createEvent(Events events);
	public List<Events> getEvents();
	public Events getEvents(String id);
	public List<Eventcategory> getEventCategory();

}
