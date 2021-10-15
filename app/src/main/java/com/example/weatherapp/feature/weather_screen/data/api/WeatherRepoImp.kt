package com.example.weatherapp.feature.weather_screen.data.api

import com.example.weatherapp.feature.weather_screen.data.toDomain
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherRepoImp(
    private val weatherRemoteSource: WeatherRemoteSource
) : WeatherRepo {

    override suspend fun getWeather(cityName: String): WeatherDomainModel {
        return weatherRemoteSource.getWeather(cityName).toDomain()
    }
}