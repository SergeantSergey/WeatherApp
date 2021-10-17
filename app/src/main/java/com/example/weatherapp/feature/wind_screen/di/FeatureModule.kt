package com.example.weatherapp.feature.wind_screen.di

import com.example.weatherapp.feature.wind_screen.ui.WindScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val windScreenModule = module {

    viewModel {
        WindScreenViewModel(weatherInteractor = get(), cityInteractor = get())
    }
}