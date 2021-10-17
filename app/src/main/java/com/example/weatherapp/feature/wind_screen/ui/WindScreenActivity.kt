package com.example.weatherapp.feature.wind_screen.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WindScreenActivity : AppCompatActivity() {

    private val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_wind_screen)

        windScreenViewModel.windLiveData.observe(this, Observer(::render))

        findViewById<Button>(R.id.btnRequestWind).setOnClickListener {
            windScreenViewModel.requestWind()
        }
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvWind).text = getString(R.string.wind_speed, state.windSpeed)
    }
}