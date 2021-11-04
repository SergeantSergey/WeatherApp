package com.example.weatherapp.feature.weather_screen.ui

import com.example.weatherapp.base.Event

data class ViewState(
    val temperature: Float,
    val temperatureMax: Float,
    val temperatureMin: Float,
    val humidity: Int,
    val errorMessage: String
)

sealed class UiEvent : Event {
    object RequestWeather : UiEvent()
}

sealed class DataEvent : Event {

    data class SuccessWeatherRequest(
        val temperature: Float,
        val temperatureMax: Float,
        val temperatureMin: Float,
        val humidity: Int
    ) : DataEvent()

    data class ErrorWeatherRequest(val error: String) : DataEvent()
}