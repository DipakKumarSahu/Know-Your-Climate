<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Weather Hunt</title>
<link rel="stylesheet" href="next.css">
 <link rel="icon" href="images/1163661.png" type="image/png">

</head>
<body>
 <h4><img src="images/Know your Climate2.svg" alt="" style = width:65vw;></h4>


 
 <h1 style="text-align: center;font-size: 40px;color: #fff5f5cf; ">${city.toUpperCase()}</h1>
 
 <form action="MyServlet" method="post">
    <input name="city" type="text" placeholder="Enter the location"></input>
    <button>Submit</button>
  </form>
  
  <% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
  <div style="color: red; text-align: center; margin: 10px; font-size:15px;">
    <strong><%= error %></strong>
  </div>
<% } %>
  
 

  <div class="result">
         <div class="dateTime"> 
            <div id ="hour" class="date">${date}</div>
        </div>
        
        <div class="attributes">
            <div class="box1 pad"> 
                <div class="wi"><img class="image-edit"  src="" alt="Clouds" id="weather-icon"></div>
                <div style="margin-top:10px;" class="text text-edit">Weather</div>
                <div class="season deg-edit "></div>
                <input type="hidden" id="wc" value="${weatherCondition}">
            </div>
             <div class="box4 pad"> 
                <div class="pic thermometer"><img src="images/thermometer.png" alt="thermometer"></div>
                <div class="text text-edit">Temperature</div>
                <div class="value deg-edit">${temperature}&degC</div>
            </div>
            <div class="box2 pad"> 
                <div class="humpic humidity"><img src="images/humidity.png" alt="humidity"></div>
                <div class="text text-edit exmar">Humidity</div>
                <div class="value deg-edit">${humidity}%</div>
            </div>
            <div class="box3 pad"> 
                <div class="pic windpic"><img src="images/giphy.gif" alt="wind"></div>
                <div class="text text-edit">Wind Speed</div>
                <div class="value deg-edit">${windSpeed}km/h</div>
            </div>
       
            
          </div>
	</div>
  <script src="script.js"></script>
  
  
</body>
</html>