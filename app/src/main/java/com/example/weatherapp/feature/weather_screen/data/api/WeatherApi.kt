package com.example.weatherapp.feature.weather_screen.data.api

import com.example.weatherapp.feature.weather_screen.data.model.WeatherModel
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("units") units: String,
        @Query("lang") lang: String = "ru",
        @Query("appid") appId: String = "84f546f4bdea88202107f69b8411f1ed"
    ): WeatherModel
}