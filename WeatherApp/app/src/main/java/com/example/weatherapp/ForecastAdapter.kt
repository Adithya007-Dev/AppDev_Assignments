package com.example.weatherapp

// ForecastAdapter.kt
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.ItemForecastBinding

class ForecastAdapter(private val forecasts: List<WeatherResponse>) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding = ItemForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecasts[position])
    }

    override fun getItemCount(): Int = forecasts.size

    class ForecastViewHolder(private val binding: ItemForecastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: WeatherResponse) {
            binding.forecastDate.text = weather.dt_txt
            binding.forecastTemp.text = "${weather.main.temp} °C"
            binding.forecastDescription.text = weather.weather[0].description
            Glide.with(binding.root.context)
                .load("https://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png")
                .into(binding.forecastIcon)
        }
    }
}

