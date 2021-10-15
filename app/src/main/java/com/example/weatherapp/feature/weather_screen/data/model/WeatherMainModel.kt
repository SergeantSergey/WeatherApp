package com.example.weatherapp.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainModel(

    @SerializedName("temp")
    val temp: Float,

    @SerializedName("temp_min")
    val tempMin: Float,

    @SerializedName("temp_max")
    val tempMax: Float,

    @SerializedName("humidity")
    val humidity: Int
)