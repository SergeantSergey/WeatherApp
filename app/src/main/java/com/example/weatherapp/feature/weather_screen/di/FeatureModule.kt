package com.example.weatherapp.feature.weather_screen.di

import com.example.weatherapp.feature.weather_screen.data.api.WeatherApi
import com.example.weatherapp.feature.weather_screen.data.api.WeatherRemoteSource
import com.example.weatherapp.feature.weather_screen.data.api.WeatherRepo
import com.example.weatherapp.feature.weather_screen.data.api.WeatherRepoImp
import com.example.weatherapp.feature.weather_screen.domain.WeatherInteractor
import com.example.weatherapp.feature.weather_screen.ui.WeatherScreenActivity
import com.example.weatherapp.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

val weatherScreenModule = module {

    single {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    scope<WeatherScreenActivity> {

        viewModel {
            WeatherScreenViewModel(weatherInteractor = get(), cityInteractor = get())
        }

        scoped {
            WeatherInteractor(weatherRepo = get())
        }

        scoped<WeatherRepo> {
            WeatherRepoImp(weatherRemoteSource = get())
        }

        scoped {
            WeatherRemoteSource(api = get())
        }
    }
}