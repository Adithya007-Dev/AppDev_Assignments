package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val apiKey = "653128dc6115ba83b63e866a772fc259"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.searchButton.setOnClickListener {
            val city = binding.searchCity.text.toString()
            if (city.isNotEmpty()) {
                getCurrentWeather(city)
                getWeatherForecast(city)
            }
        }
    }

    private fun getCurrentWeather(city: String) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getCurrentWeather(city, apiKey).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weather = response.body()
                    weather?.let {
                        val weatherInfo = """
                            City: ${it.name}
                            Temperature: ${it.main.temp} °C
                            Humidity: ${it.main.humidity}%
                            Wind Speed: ${it.wind.speed} m/s
                            Description: ${it.weather[0].description}
                        """.trimIndent()
                        binding.currentWeather.text = weatherInfo
                    }
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("MainActivity", "Error fetching current weather", t)
            }
        })
    }

    private fun getWeatherForecast(city: String) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getWeatherForecast(city, apiKey).enqueue(object : Callback<ForecastResponse> {
            override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                if (response.isSuccessful) {
                    val forecast = response.body()?.list ?: emptyList()
                    binding.recyclerView.adapter = ForecastAdapter(forecast)
                }
            }

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                Log.e("MainActivity", "Error fetching weather forecast", t)
            }
        })
    }
}