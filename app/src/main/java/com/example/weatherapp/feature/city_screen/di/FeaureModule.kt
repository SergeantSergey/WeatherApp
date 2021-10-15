package com.example.weatherapp.feature.city_screen.di

import com.example.weatherapp.feature.city_screen.data.store.CityDataStore
import com.example.weatherapp.feature.city_screen.data.store.DataStoreRepository
import com.example.weatherapp.feature.city_screen.data.store.DataStoreRepositoryImpl
import com.example.weatherapp.feature.city_screen.domain.CityInteractor
import com.example.weatherapp.feature.city_screen.ui.CityScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cityScreenModule = module {

    single {
        CityDataStore(context = androidContext())
    }

    single<DataStoreRepository> {
        DataStoreRepositoryImpl(cityDataStore = get())
    }

    single {
        CityInteractor(dataStoreRepository = get())
    }

    viewModel {
        CityScreenViewModel(cityInteractor = get())
    }
}