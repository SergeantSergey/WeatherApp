package com.example.weatherapp.feature.weather_screen.data.api

import com.example.weatherapp.feature.weather_screen.data.model.WeatherModel

class WeatherRemoteSource(
    private val api: WeatherApi
) {

    suspend fun getWeather(cityName:String): WeatherModel {

        return api.getWeather(
            cityName = cityName,
            units = "metric"
        )
    }
}