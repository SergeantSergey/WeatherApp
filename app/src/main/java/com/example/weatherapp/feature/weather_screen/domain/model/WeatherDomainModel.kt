package com.example.weatherapp.feature.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: Float = 0F,
    val temperatureMax: Float = 0F,
    val temperatureMin: Float = 0F,
    val humidity: Int,
    val windSpeed: Float
)