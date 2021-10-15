package com.example.weatherapp.feature.city_screen.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityScreenActivity : AppCompatActivity() {

    private val cityScreenViewModel by viewModel<CityScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_city_screen)

        cityScreenViewModel.setCityName("Orenburg")
    }
}