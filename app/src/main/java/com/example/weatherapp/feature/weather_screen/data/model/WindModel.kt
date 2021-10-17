package com.example.weatherapp.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WindModel(

    @SerializedName("speed")
    val speed: Float,

    @SerializedName("deg")
    val deg: Int
)