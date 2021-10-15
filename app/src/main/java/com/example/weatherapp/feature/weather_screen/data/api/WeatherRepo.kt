package com.example.weatherapp.feature.weather_screen.data.api

import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepo {

    suspend fun getWeather(cityName:String): WeatherDomainModel
}