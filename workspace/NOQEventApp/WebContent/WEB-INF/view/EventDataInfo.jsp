
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
  <title>NoQ Event</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
 <link rel="stylesheet" type="text/css" href="${pathvalue}css/style.css" title="style" />
</head>

<body>
   <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="${pathvalue}home.html">No-Q <span class="logo_colour">Event</span></a></h1>
          <h2>NOQ Events</h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li class="selected"><a href="${pathvalue}events.html">Events</a></li>
          
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
     <div class="sidebar">
     	 <c:if test="${!empty sessionScope.username}">
      
      	  <form action="${pathvalue}logout.html" method="post">
      	  <div class="button_settings">
           <input class="submit" type="submit" name="submit" value="Logout" /></div>
        </form>
        
      </c:if>
     </div>
      <div id="content">
        <h1>Event Title </h1>
          <div class="button_settings">
            <p>${eventtitle } 
             </p>
            <p><span>${eventdate } </span>
              </p>
              <p><span>${organiser} </span>
              </p>
              <p><span>${organisermail } </span>
              </p>
			 <c:if test="${empty sessionScope.username}">              
            <p style="padding-top: 15px"><span>&nbsp;</span>
              <a href="${pathvalue}loginPage.html" ><input type=button class=submit value="Login"/></a>
            </p>
            </c:if>
              <c:if test="${!empty sessionScope.username}">
                <p style="padding-top: 15px"><span>&nbsp;</span>
              <a href="${pathvalue}registerToEvent.html" ><input type=button class=submit value="Register"/></a>
            </p>
              </c:if>
          </div>
      
        <p><br/>
        </p>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; Lisystems </div>
  </div>
</body>
</html>
