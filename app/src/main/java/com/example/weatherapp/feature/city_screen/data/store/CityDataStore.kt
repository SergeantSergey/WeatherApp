package com.example.weatherapp.feature.city_screen.data.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.weatherapp.feature.city_screen.data.store.model.CityPreferencesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CityDataStore(private val context: Context) {

    companion object {
        private const val CITY_PREFERENCES_NAME = "CITY_PREFERENCES_NAME"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = CITY_PREFERENCES_NAME)
    }

    private val cityName = CityScheme.CITY_NAME

    fun getName(): Flow<CityPreferencesModel> = context.dataStore.data.map {
        CityPreferencesModel(
            cityName = it[cityName] ?: "Moscow"
        )
    }

    suspend fun setName(name: String) = context.dataStore.edit {
        it[cityName] = name
    }
}