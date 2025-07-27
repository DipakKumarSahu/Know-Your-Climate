package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileNotFoundException{
		try {
		String inputData = request.getParameter("userInput");
		
		// Get the api key
		String apiKey = "your api key";
		
		//Get the city 
		String city = request.getParameter("city");
		
		// API
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey;
		
		// API Integration for URL pass
				URL url = new URL(apiUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				
				//Reading the data from network
				InputStream inputStream = connection.getInputStream();
				InputStreamReader reader = new InputStreamReader(inputStream);
				
				// want to Store in a String
				StringBuilder responseContent = new StringBuilder();
				
				//Input lene ke liye from reader , will create scanner object.
				Scanner scanner = new Scanner(reader);
		
				while(scanner.hasNext()) {
					responseContent.append(scanner.nextLine());
				}
				
				// scanner ka kaam khatam so we close the scanner.
				scanner.close();
				System.out.println(responseContent);
				
				// Type casting String to Json (json mein convert karne ke badh hum alag alag karke value 				extract kar sakte hein)
				 // Parse the JSON response to extract temperature, date, and humidity
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
				
				
				// ye sab json se value get karke variable mein store kar rahe hein.
				// Date & Time
//				long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
//				String date = new Date(dateTimestamp).toString();
				
				
	            // Extracting data
	            long timestamp = jsonObject.get("dt").getAsLong() * 1000L;
	            Date date1 = new Date(timestamp);
	            SimpleDateFormat dateFormatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
	            String date = dateFormatter.format(date1);
	            System.out.println(date);
	            String[] parts = date.split(" ");
	            String timePart = parts[4];
	            String hour = timePart.split(":")[0];
	            System.out.println(hour);
	           int val = Integer.parseInt(hour);
	           System.out.println("Hour = "+val);
				
				
				// Temperature
				double tempratureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
				int temperatureCelsius = (int) (tempratureKelvin - 273.15);
				
				//Humidity
				int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
				
				//Wind Speed
				double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
				
				//Weather Condition (iske hisaab se icon aayega )
				 String weatherCondition = 				jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
				
				
				 // Set the data as request attributes (for sending to the jsp page)
		         request.setAttribute("date", date);
		         request.setAttribute("city", city);
		         request.setAttribute("temperature", temperatureCelsius);
		         request.setAttribute("weatherCondition", weatherCondition); 
		         request.setAttribute("humidity", humidity);    
		         request.setAttribute("windSpeed", windSpeed);
		         request.setAttribute("weatherData", responseContent.toString());
		
		
		         connection.disconnect();
		         
			 } catch (IOException e) {
		         e.printStackTrace();
		     }

		     // Forward the request to the weather.jsp page for rendering
		     request.getRequestDispatcher("index.jsp").forward(request, response);
		 
				
				
		
		
		doGet(request, response);
	}

}
