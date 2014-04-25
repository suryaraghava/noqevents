package com.noq.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.noq.domain.Events;
import com.noq.formviews.EventRegistration;
import com.noq.service.EventService;


@Controller

public class EventController {
	@Autowired
	EventService eventService;
	
	@RequestMapping("/events")
	public ModelAndView getEvents(HttpSession session){
		System.out.println("session data"+session.getAttribute("username"));
		String username =(String) session.getAttribute("username");
		Map<String, Object> model = new HashMap<String, Object>();
		List<Events> events = eventService.getEvents();
		model.put("headerpage", "header.html");
		if(!events.isEmpty()){
		model.put("latest",events.get(0).getEventtitle());
		
		model.put("events", events);
		}
		model.put("username", username);
		
		return new ModelAndView("EventData", model);
	}
	
	@RequestMapping("/registerToEvent")
	public ModelAndView registerToEvents(@ModelAttribute("EventRegistration") EventRegistration eventRegistration, HttpSession session){
		ModelAndView modelView = new ModelAndView();
		String userName = (String) session.getAttribute("username");
		if(userName!=null){
		modelView.setViewName("UserRegistration");
		}
		else
		{
			modelView.setViewName("EventData");
		}
		Map<String, Object> model = new HashMap<String, Object>();
		return modelView;
	}
	
	@RequestMapping("/createEvent")
	public ModelAndView createEvent(){
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("EventRegistration");
		return modelView;
	}
	
	@RequestMapping("/registerNewEvent")
	public ModelAndView registerNewEvent(@ModelAttribute("EventRegistration") EventRegistration eventRegistration, HttpSession session){
		ModelAndView modelView = new ModelAndView();
		String userName = (String) session.getAttribute("username");
		int userid=1;
		String eventName = eventRegistration.getEventname();
		String location = eventRegistration.getLocation();
		String organiser = eventRegistration.getOrganiser();
		String date =eventRegistration.getDate();
		String description = eventRegistration.getDescription();
		int category = 1;
		String organizerNumber="1234";
		Events events = new Events();
		events.setEventdate(new Date(0));
		events.setEventdetails(description);
		events.setEventtitle(eventName);
		events.setCreatedby(userid);
		events.setEventcategory(category);
		events.setEventorganisermailid(organiser);
		events.setEventorganisernumber(organizerNumber);
		if(eventService.addEvent(events)){
			modelView.setViewName("redirect:/events.html");	
		}
		else{
			modelView.setViewName("redirect:/createEvent.html");
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		return modelView;
	}
	
	@RequestMapping("/getEvent/{id}")
	public ModelAndView getEventDetails(@PathVariable("id") String id){
		Map<String, Object> model = new HashMap<String, Object>();
		Events events = eventService.getEvents(id);
		
		model.put("eventtitle",events.getEventtitle());
		model.put("eventdate", events.getEventdate());
		model.put("pathvalue", "../");
		return new ModelAndView("EventDataInfo", model);
	}
	

}