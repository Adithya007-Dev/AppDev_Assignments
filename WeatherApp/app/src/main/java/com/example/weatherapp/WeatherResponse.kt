package com.example.weatherapp

data class WeatherResponse(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val name: String,
    val dt_txt: String
)
data class Weather(
    val description: String,
    val icon: String
)

data class Main(
    val temp: Float,
    val humidity: Int
)

data class Wind(
    val speed: Float
)

// ForecastResponse.kt
data class ForecastResponse(
    val list: List<WeatherResponse>
)