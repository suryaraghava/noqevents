function getEventData()
	{
     $.get("http://localhost:8080/application/EventData", function (data) {
        
         var   jsonObj1 = jQuery.parseJSON(data);
       alert(data);
         if(jsonObj1.result=='000')
           {
                jsonObj = jsonObj1.eventdata;
                for (var id in jsonObj) {
                	setEventData(jsonObj[id]);
                	
                }
                
           }
     });
	}
     function setEventData(values)
     {
    	 var html="";
    		    var template = " <h2>{{eventtitle}}</h2> <h5>{{eventdate}}</h5><p>{{eventname}}<br /><a href=\"{{eventurl}}\">See More</a></p>";
    		    html = Mustache.to_html(template, values);
    		    alert(html);
    	
    	 
    	$('#content').append(html);
      
     }
     
     function getLatestEvent()
     {
    	  $.get("http://localhost:8080/application/LatestEventData", function (data) {
    	        
    	         var   jsonObj1 = jQuery.parseJSON(data);
    	       alert(data);
    	         if(jsonObj1.result=='000')
    	           {
    	                jsonObj = jsonObj1.eventdata;
    	                for (var id in jsonObj) {
    	                	setLatestEventData(jsonObj[id]);
    	                	
    	                }
    	                
    	           }
    	     });
     }
     function setLatestEventData(values)
     {
    	 var html="";
    		    var template = " <h2>{{eventtitle}}</h2> <h5>{{eventdate}}</h5><p>{{eventname}}<br /><a href=\"{{eventurl}}\">See More</a></p>";
    		    html = Mustache.to_html(template, values);
    		    alert(html);
    	
    	 
    	$('#contentData').append(html);
      
     }
     