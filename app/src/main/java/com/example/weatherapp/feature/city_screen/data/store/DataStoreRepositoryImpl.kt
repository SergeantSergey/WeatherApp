package com.example.weatherapp.feature.city_screen.data.store

import com.example.weatherapp.feature.city_screen.data.store.model.CityPreferencesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first

class DataStoreRepositoryImpl(
    private val cityDataStore: CityDataStore
) : DataStoreRepository {

    override suspend fun setName(name: String) {
        cityDataStore.setName(name)
    }

    override suspend fun getName(): CityPreferencesModel {
        return cityDataStore.getName().first()
    }
}