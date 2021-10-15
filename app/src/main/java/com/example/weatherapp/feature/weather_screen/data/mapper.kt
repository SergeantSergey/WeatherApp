package com.example.weatherapp.feature.weather_screen.data

import com.example.weatherapp.feature.weather_screen.data.model.WeatherModel
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel

fun WeatherModel.toDomain(): WeatherDomainModel {
    return WeatherDomainModel(
        temperature = this.main.temp,
        temperatureMax = this.main.tempMax,
        temperatureMin = this.main.tempMin,
        humidity = this.main.humidity
    )
}