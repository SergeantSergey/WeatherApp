package com.example.weatherapp.feature.city_screen.domain

import com.example.weatherapp.feature.city_screen.data.store.DataStoreRepository
import com.example.weatherapp.feature.city_screen.data.store.model.CityPreferencesModel
import kotlinx.coroutines.flow.Flow

class CityInteractor(val dataStoreRepository: DataStoreRepository) {

    suspend fun setName(name: String) {
        dataStoreRepository.setName(name)
    }

    suspend fun getName(): CityPreferencesModel {
        return dataStoreRepository.getName()
    }
}