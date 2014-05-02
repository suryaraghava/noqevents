
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
    <h4>${message}</</h4>
      <div class="sidebar">
     <c:if test="${empty sessionScope.username}">
      <h3>Login</h3>
        <form action="login.html" method="post">
          <div class="form_settings">
            <p><span>User Name</span><input class="contact" type="text" name="username" value="" autofocus/></p>
            <p><span>Password</span><input class="contact" type="password" name="password" value="" /></p>            
            <p style="padding-top: 15px"><span><input class="submit" type="submit" name="submit" value="Login" /></span>
            <a href="signup.html"><input class="submit" type="button" name="submit" value="Signup" /></a></p>
          </div>
        </form>
     </c:if>
      <c:if test="${!empty sessionScope.username}">
      <h4>Welcome  <c:out value="${username}"/>
      	  <form action="logout.html" method="post">
           <div class="button_settings">
            <p ><span><input class="submit" type="submit" name="submit" value="Logout" /></span>
          </div>
        </form>
        </h4>
      </c:if>
     
      
        <!-- insert your sidebar items here -->
        <h3>Latest Events</h3>
        <div id="contentData">
        <h2><c:out value="${latest}"/></h2> 
       </div>
        <h3>Useful Links</h3>
        <ul>
          <li><a href="#">Arts</a></li>
          <li><a href="#">Classical</a></li>
          <li><a href="#">Rock</a></li>
          <li><a href="#">Moon Light</a></li>
        </ul>
        <h3>Search</h3>
        <form method="post" action="#" id="search_form">
          <p>
            <input class="search" type="text" name="search_field" value="Enter keywords....." />
            <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="images/search.png" alt="Search" title="Search" />
          </p>
        </form>
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <c:if test="${!empty sessionScope.username}">
        <div class="button_settings">
        <a href="createEvent.html"><input type=button class=submit value="Create Event"/></a>
        </div>
        </c:if>
        <h1>Events</h1>
        
     <!--  
        <h2>{eventtitle}</h2>
        <h5>{eventdate}</h5>
        <p>{eventname}<br /><a href="{eventurl}">See More</a></p>
       
        <p>&nbsp;</p>-->
       
        
         <c:forEach items="${events}" var="events">
         <c:if test="${!empty events}">
        <h2><c:out value="${events.eventtitle}"/></h2> 
        <h5><c:out value="${events.eventdate}"/></h5>
        <p><c:out value="${events.eventdetails}"/><br />
        <a href=<c:out value="getEvent/${events.eventid}.html"/>>See More</a></p>
        </c:if>
        
        </c:forEach>
       
     <c:if test="${empty events}"><h3>No Events To Display</h3></c:if>
        <form action="#" method="post">
        <div class="form_settings">          </div>
        </form>
      </div>
    </div>
     <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; Lisystems </div>
  </div>
  </div>
</body>
</html>
