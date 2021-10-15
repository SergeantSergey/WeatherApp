package com.example.weatherapp.feature.city_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.feature.city_screen.domain.CityInteractor
import kotlinx.coroutines.launch

class CityScreenViewModel(private val cityInteractor: CityInteractor) : ViewModel() {

    fun setCityName(name: String) {
        viewModelScope.launch {
            cityInteractor.setName(name)
        }
    }
}