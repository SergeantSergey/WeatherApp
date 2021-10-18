package com.example.weatherapp.feature.city_screen.ui

import com.example.weatherapp.base.BaseViewModel
import com.example.weatherapp.base.Event
import com.example.weatherapp.feature.city_screen.domain.CityInteractor

class CityScreenViewModel(private val cityInteractor: CityInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(
            errorMessage = ""
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {

            is UiEvent.SetCity -> {
                cityInteractor.setName(event.cityName)
            }
        }

        return null
    }
}