package com.noq.formviews;

public class EventRegistration {
String eventname;
String location;
String organiser;
String organiserPhone;
String organiserMail;
String date;
int category;
String eventType;
String noOfSeats;
String description;
public String getEventname() {
	return eventname;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public String getEventType() {
	return eventType;
}
public void setEventType(String eventType) {
	this.eventType = eventType;
}
public String getNoOfSeats() {
	return noOfSeats;
}
public void setNoOfSeats(String noOfSeats) {
	this.noOfSeats = noOfSeats;
}
public void setEventname(String eventname) {
	this.eventname = eventname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getOrganiser() {
	return organiser;
}
public void setOrganiser(String organiser) {
	this.organiser = organiser;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getOrganiserPhone() {
	return organiserPhone;
}
public void setOrganiserPhone(String organiserPhone) {
	this.organiserPhone = organiserPhone;
}
public String getOrganiserMail() {
	return organiserMail;
}
public void setOrganiserMail(String organiserMail) {
	this.organiserMail = organiserMail;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
