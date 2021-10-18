package com.example.weatherapp.feature.city_screen.ui

import com.example.weatherapp.base.Event

data class ViewState(
    val errorMessage: String
)

sealed class UiEvent : Event {
    data class SetCity(
        val cityName: String
    ) : UiEvent()
}