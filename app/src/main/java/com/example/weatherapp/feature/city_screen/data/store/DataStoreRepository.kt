package com.example.weatherapp.feature.city_screen.data.store

import com.example.weatherapp.feature.city_screen.data.store.model.CityPreferencesModel
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun setName(name: String)

    suspend fun getName(): Flow<CityPreferencesModel>
}