package com.example.weatherapp.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("cod")
    val cod: Int,

    @SerializedName("main")
    val main: WeatherMainModel,

    @SerializedName("wind")
    val wind: WindModel
)