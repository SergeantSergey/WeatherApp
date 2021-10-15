package com.example.weatherapp.feature.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: Float,
    val temperatureMax: Float,
    val temperatureMin: Float,
    val humidity:Int
)