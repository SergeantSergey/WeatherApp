package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.feature.city_screen.di.cityScreenModule
import com.example.weatherapp.feature.weather_screen.di.weatherScreenModule
import com.example.weatherapp.feature.wind_screen.di.windScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@App)
            // declare modules
            modules(appModule, weatherScreenModule, cityScreenModule, windScreenModule)
        }

        // log
        Timber.plant(Timber.DebugTree())
    }
}