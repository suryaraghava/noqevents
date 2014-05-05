
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>NoQ Event</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
 <link rel="stylesheet" type="text/css" href="css/style.css" title="style" />
 <script type="text/javascript">
 function showAvailbility(){
	
	 var catetype=document.event.catetype.value;
	 if(catetype=="limit"){
		//document.event.getElementById("seatavail").style.visibility="hidden";
	 document.getElementById("seatavail").readOnly=false;
	 }
	 else{
		 document.getElementById("seatavail").readOnly=true;
	 }
 }
 </script>
</head>
<body>
   <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="home.html">No-Q <span class="logo_colour">Event</span></a></h1>
          <h2>NOQ Events</h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          
          <li class="selected"><a href="events.html">Events</a></li>
          
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
      <div class="sidebar">
     	 <c:if test="${!empty sessionScope.username}">
      
      	  <form action="logout.html" method="post" >
      	  <div class="button_settings">
           <input class="submit" type="submit" name="submit" value="Logout" /></div>
        </form>
        
      </c:if>
     </div>
      <div id="content">
        <h1>Event Registration </h1>
        <form action="registerNewEvent.html" method="post" name="event">
          <div class="form_settings">
            <p><span>Event Name</span><input class="contact" type="text" name="eventname" value="" /></p>
            <p><span>Location</span>
              <input class="contact" type="text" name="location" value="" />
            </p>
			   <p><span>Organizer </span>
              <input class="contact" type="text" name="organiser" value="" />
            </p>
             <p><span>Organizer Phone</span>
              <input class="contact" type="text" name="organiserPhone" value="" />
            </p>
               <p><span>Organizer Email</span>
              <input class="contact" type="text" name="organiserMail" value="" />
            </p>
              <p><span>Event Category </span>
              <select name="category">
              <c:forEach items="${eventcategory}" var="eventcategory">
               <option class="contact" value="${eventcategory.id}" />${eventcategory.category}
              </c:forEach>
             </select>
              
            </p>
             <p><span>Event Type </span>
              
              Limited<input class="radio" type="radio" name="eventType"  value="limit" onchange="showAvailbility()" >
              
               Open<input class="radio"  type="radio" name="eventType" value="open" onchange="showAvailbility()"><br>
              
            </p>
            <p ><span> No Seats </span>
                <input id="seatavail" class="contact" type="text"  name="noOfSeats" value="0"/>
            </p>
            <p><span> Date</span>
                <input class="contact" type="text" name="date" value="" />
            </p>
			
            <p><span>Description</span><textarea class="contact textarea" rows="8" cols="50" name="description"></textarea>
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Register" /></p>
			 
          </div>
        </form>
        <p><br />
        </p>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; Lisystems </div>
  </div>
</body>
</html>
