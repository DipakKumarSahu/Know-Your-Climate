
 var weatherIcon = document.getElementById("weather-icon");
 	
	var val = document.getElementById("wc").value;
	document.querySelector(".season").textContent = `${val}`;
	  switch (val) {
   case 'Clouds':
	console.log("Clouds");
       //weatherIcon.src = "images/clouds-wall.jpg"; // clouds
      weatherIcon.src = "images/Clouds.png";
      document.body.style.backgroundImage = "url('images/clouds-wall.jpg')";
	 
       break;
   case 'Clear':
	console.log("Clear");
       //weatherIcon.src ="images/sun-wall.jpg"; //sun
       weatherIcon.src ="images/sun.png";
       document.body.style.backgroundImage = "url('images/sun-wall.jpg')";
	   
       break;
   case 'Rain':
	console.log("Rain");
       //weatherIcon.src = "images/rain-wall.jpeg"; // rainy
       weatherIcon.src = "images/rainy.png";
       document.body.style.backgroundImage = "url('images/rain-wall2.jpeg')";
	  
       break;
   case 'Mist':
	console.log("Mist");
      // weatherIcon.src = "images/mist-wall.jpg";//mist
       weatherIcon.src = "images/mist.png";
       document.body.style.backgroundImage = "url('images/mist-wall.jpg')";	   
       break;
	   
	   case 'Fog':
	   console.log("Fog");
	       // weatherIcon.src = "images/mist-wall.jpg";//mist
	        weatherIcon.src = "images/mist.png";
	        document.body.style.backgroundImage = "url('images/mist-wall.jpg')";	      
	        break;
   case 'Snow':
	console.log("Snow");
       //weatherIcon.src = "images/snow-wall.jpeg"; // snow
       weatherIcon.src = "images/snow.png";
       document.body.style.backgroundImage = "url('images/snow-wall.jpeg')";
	   
       break;
   case 'Haze':
	console.log("Haze");
       //weatherIcon.src = "images/haze-wall.jpg"; //haze
       weatherIcon.src = "images/haze.png";
       document.body.style.backgroundImage = "url('images/haze-wall.jpg')";	   
       break;
	   
	   case 'Smoke':
	   console.log("Smoke");
	         //weatherIcon.src = "images/haze-wall.jpg"; //haze
	         weatherIcon.src = "images/smog.png";
	         document.body.style.backgroundImage = "url('images/smog-wall.jpg')";			    
	         break;
}
console.log("Hello");
