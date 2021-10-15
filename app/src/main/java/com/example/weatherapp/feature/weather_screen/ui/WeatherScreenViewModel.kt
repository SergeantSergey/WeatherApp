package com.example.weatherapp.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.feature.city_screen.domain.CityInteractor
import com.example.weatherapp.feature.weather_screen.domain.WeatherInteractor
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WeatherScreenViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val cityInteractor: CityInteractor
) : ViewModel() {

    val weatherLiveData = MutableLiveData<WeatherDomainModel>()

    fun requestWeather() {
        viewModelScope.launch {
            cityInteractor.getName().collect {
                val value = weatherInteractor.getWeather(it.cityName)
                weatherLiveData.postValue(value)
            }
        }
    }
}