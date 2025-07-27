# 🌤️ Weather Hunt – Know Your Climate

**Weather Hunt** is a lightweight web application built using **Java (Servlet + JSP)** that fetches and displays real-time weather information for any city using the **OpenWeatherMap API**.

> 📍 Just enter your city and explore the climate conditions — live!

---

## 🚀 Features

### 🔍 City-based Search
- Enter any city's name, and get the current weather report instantly.

### ☀️ Real-time Weather Info
- Displays:
  - Temperature (in Celsius)
  - Humidity
  - Wind Speed
  - Weather Condition (e.g., Clear, Clouds, Rain)
  - Local Date & Time

### ⚠️ Smart Error Handling
- Invalid city name? Don't worry!
  - Graceful message: **"City not found or API error."**

### 💡 Dynamic Icons (ready for enhancement)
- Weather icon placeholder added (JS support required for full implementation).

---

## 🛠️ Tech Stack

| Layer        | Tech Used                  |
|--------------|----------------------------|
| Frontend     | HTML, CSS, JavaScript      |
| UI Framework | Vanilla + Responsive Design |
| Backend      | Java Servlet + JSP         |
| API          | [OpenWeatherMap API](https://openweathermap.org/current) |
| JSON Parsing | Gson                       |
| Deployment   | Apache Tomcat (Locally)    |

---

## 🧠 How It Works – Behind the Scenes

1. **User Input**: The user submits a city name via a form.
2. **Servlet Handling**: The Java Servlet (`MyServlet.java`) handles the request and constructs the OpenWeatherMap API URL.
3. **API Communication**: It opens an HTTP connection to the API and fetches JSON data.
4. **JSON Parsing**: Data like temperature, humidity, and weather condition are parsed using **Gson**.
5. **Error Check**: If response code ≠ 200, user sees a smart error message.
6. **Data Forwarding**: All data is sent to `index.jsp` for display using request attributes.
7. **Display**: Cleanly structured JSP + CSS displays the real-time weather data.

### 🎨 Dynamic Weather-Based Background

This project changes the background and weather icon dynamically based on the weather condition retrieved from the OpenWeatherMap API.

#### ☁ Supported Weather Types:

| Weather       | Icon               | Background Image        |
|---------------|--------------------|--------------------------|
| ☀️ Clear       | sun.png             | sun-wall.jpg             |
| ☁️ Clouds      | Clouds.png          | clouds-wall.jpg          |
| 🌧️ Rain        | rainy.png           | rain-wall2.jpeg          |
| 🌫️ Mist/Fog    | mist.png            | mist-wall.jpg            |
| ❄️ Snow        | snow.png            | snow-wall.jpeg           |
| 🌁 Haze        | haze.png            | haze-wall.jpg            |
| 🚬 Smoke       | smog.png            | smog-wall.jpg            |

All assets are located in the `/images` directory and used dynamically based on the weather data fetched.

---
