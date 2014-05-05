package com.noq.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.noq.domain.Eventcategory;
import com.noq.domain.Events;
import com.noq.domain.User;
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
		
		return modelView;
	}
	
	@RequestMapping("/createEvent")
	public ModelAndView createEvent(HttpSession session){
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> model = new HashMap<String, Object>();
		Integer userid = (Integer) session.getAttribute("userid");
		if(userid!=null){
			List<Eventcategory> categoryList = eventService.getEventCategory();
			model.put("eventcategory", categoryList);
		modelView=new ModelAndView("EventRegistration",model);
		}
		else
			modelView.setViewName("redirect:/loginPage.html");
		return modelView;
	}
	
	@RequestMapping("/registerNewEvent")
	public ModelAndView registerNewEvent(@ModelAttribute("EventRegistration") EventRegistration eventRegistration, HttpSession session){
		ModelAndView modelView = new ModelAndView();
		String userName = (String) session.getAttribute("username");
		int userid=(Integer)session.getAttribute("userid");
		User user = new User();
		user.setUserId(userid);
		
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
	    // myDate is the java.util.Date in yyyy-mm-dd format
	    // Converting it into String using formatter
	   
		String eventName = eventRegistration.getEventname();
		String location = eventRegistration.getLocation();
		String organiser = eventRegistration.getOrganiser();
		String eventDate =eventRegistration.getDate();
		System.out.println(eventDate);
		// String strDate = sm.format(eventDate);
		    //Converting the String back to java.util.Date
		    Date eventdate = null;
			try {
				eventdate = new Date(sm.parse(eventDate).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String description = eventRegistration.getDescription();
		int category = eventRegistration.getCategory();
		String eventType = eventRegistration.getEventType();
		String organiserPhone = eventRegistration.getOrganiserPhone();
		String organiserMail = eventRegistration.getOrganiserMail();
		String noOfSeats = eventRegistration.getNoOfSeats();
		
		Events events = new Events();
		events.setUser(user);
		events.setEventdate(new Date(0));
		events.setEventdetails(description);
		events.setEventtitle(eventName);
		events.setCreatedby(userid);
		events.setEventcategory(category);
		events.setEventorganisermailid(organiser);
		events.setEventorganisernumber(organiserPhone);
		events.setEventlocation(location);
		events.setEventorganisermailid(organiserMail);
		events.setEventtype(eventType);
		events.setNoofseats(noOfSeats);
		events.setEventdate(eventdate);
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
		model.put("organiser", events.getUser().getFirstName());
		model.put("organisermail", events.getEventorganisermailid());
		model.put("pathvalue", "../");
		return new ModelAndView("EventDataInfo", model);
	}
	
	@RequestMapping("/getEventCategory/{category}") 
	public ModelAndView getEventCategoryDetails(@PathVariable("category") String id){
		Map<String, Object> model = new HashMap<String, Object>();
		Events events = eventService.getEvents(id);
		
		model.put("eventtitle",events.getEventtitle());
		model.put("eventdate", events.getEventdate());
		model.put("pathvalue", "../");
		return new ModelAndView("EventDataInfo", model);
	}

}
