package com.example.weatherapp.feature.wind_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.feature.city_screen.domain.CityInteractor
import com.example.weatherapp.feature.weather_screen.domain.WeatherInteractor
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WindScreenViewModel(
    val weatherInteractor: WeatherInteractor,
    private val cityInteractor: CityInteractor
) : ViewModel() {

    val windLiveData = MutableLiveData<WeatherDomainModel>()

    fun requestWind() {
        viewModelScope.launch {
            val cityModel = cityInteractor.getName()
            val value = weatherInteractor.getWeather(cityModel.cityName)
//            windLiveData.postValue(value)
        }
    }
}