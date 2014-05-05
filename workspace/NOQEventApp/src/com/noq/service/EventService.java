package com.noq.service;

import java.util.List;

import com.noq.domain.Eventcategory;
import com.noq.domain.Events;

public interface EventService {

	public boolean addEvent(Events events);
	public List<Events> getEvents();
	public Events getEvents(String id);
	public List<Eventcategory> getEventCategory();
}
