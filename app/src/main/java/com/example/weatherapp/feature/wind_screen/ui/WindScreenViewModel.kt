package com.example.weatherapp.feature.wind_screen.ui

import com.example.weatherapp.base.BaseViewModel
import com.example.weatherapp.base.Event
import com.example.weatherapp.feature.city_screen.domain.CityInteractor
import com.example.weatherapp.feature.weather_screen.domain.WeatherInteractor

class WindScreenViewModel(
    val weatherInteractor: WeatherInteractor,
    private val cityInteractor: CityInteractor
) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(
            windSpeed = 0F,
            errorMessage = ""
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {

            is UiEvent.RequestWind -> {
                val cityModel = cityInteractor.getName()
                weatherInteractor.getWeather(cityModel.cityName).fold(
                    onSuccess = { weatherDomainModel ->
                        processDataEvent(
                            DataEvent.SuccessWindRequest(
                                windSpeed = weatherDomainModel.windSpeed
                            )
                        )
                    },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorWindRequest(it.localizedMessage ?: "Error!")
                        )
                    }
                )
            }

            is DataEvent.SuccessWindRequest -> {
                return previousState.copy(
                    windSpeed = event.windSpeed
                )
            }

            is DataEvent.ErrorWindRequest -> {
                return previousState.copy(
                    errorMessage = event.errorMessage
                )
            }
        }
        return null
    }
}