package com.example.weatherapp.feature.weather_screen.ui

import com.example.weatherapp.base.BaseViewModel
import com.example.weatherapp.base.Event
import com.example.weatherapp.feature.city_screen.domain.CityInteractor
import com.example.weatherapp.feature.weather_screen.domain.WeatherInteractor

class WeatherScreenViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val cityInteractor: CityInteractor
) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(
            temperature = 0F,
            temperatureMax = 0F,
            temperatureMin = 0F,
            humidity = 0,
            errorMessage = ""
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {

            is UiEvent.RequestWeather -> {
                val cityModel = cityInteractor.getName()
                weatherInteractor.getWeather(cityModel.cityName).fold(
                    onSuccess = { weatherDomainModel ->
                        processDataEvent(
                            DataEvent.SuccessWeatherRequest(
                                temperature = weatherDomainModel.temperature,
                                temperatureMax = weatherDomainModel.temperatureMax,
                                temperatureMin = weatherDomainModel.temperatureMin,
                                humidity = weatherDomainModel.humidity
                            )
                        )
                    },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorWeatherRequest(it.localizedMessage ?: "Error!")
                        )
                    }
                )
            }

            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(
                    temperature = event.temperature,
                    temperatureMin = event.temperature,
                    temperatureMax = event.temperatureMax,
                    humidity = event.humidity,
                    errorMessage = ""
                )
            }

            is DataEvent.ErrorWeatherRequest -> {
                return previousState.copy(
                    errorMessage = event.error
                )
            }
        }

        return null
    }
}