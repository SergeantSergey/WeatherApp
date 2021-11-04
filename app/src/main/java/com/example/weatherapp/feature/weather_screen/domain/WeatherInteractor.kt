package com.example.weatherapp.feature.weather_screen.domain

import com.example.weatherapp.base.attempt
import com.example.weatherapp.feature.weather_screen.data.api.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(cityName: String) = attempt {
        weatherRepo.getWeather(cityName)
    }
}