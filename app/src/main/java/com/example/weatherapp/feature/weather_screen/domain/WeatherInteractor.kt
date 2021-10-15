package com.example.weatherapp.feature.weather_screen.domain

import com.example.weatherapp.feature.weather_screen.data.api.WeatherRepo
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(cityName: String): WeatherDomainModel {
        return weatherRepo.getWeather(cityName)
    }
}