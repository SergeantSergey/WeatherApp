package com.example.weatherapp.feature.wind_screen.ui

import com.example.weatherapp.base.Event

data class ViewState(
    val windSpeed: Float,
    val errorMessage: String
)

sealed class UiEvent : Event {
    object RequestWind : UiEvent()
}

sealed class DataEvent : Event {

    data class SuccessWindRequest(
        val windSpeed: Float
    ) : DataEvent()

    data class ErrorWindRequest(val errorMessage: String) : DataEvent()
}