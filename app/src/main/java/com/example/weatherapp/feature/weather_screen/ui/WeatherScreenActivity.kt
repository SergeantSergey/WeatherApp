package com.example.weatherapp.feature.weather_screen.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.R
import com.example.weatherapp.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityRetainedScope
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ViewModelOwnerDefinition
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.scope.getViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.scope.Scope

class WeatherScreenActivity : AppCompatActivity(), AndroidScopeComponent {

    override val scope: Scope by activityScope()

    private val weatherViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_weather_screen)

        val btnGet = findViewById<Button>(R.id.btnGet)

        weatherViewModel.weatherLiveData.observe(this, Observer(::render))

        btnGet.setOnClickListener {
            weatherViewModel.requestWeather()
        }
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvTemperature).text =
            getString(R.string.temperature, state.temperature)
        findViewById<TextView>(R.id.tvTemperatureMax).text =
            getString(R.string.temperature_max, state.temperatureMax)
        findViewById<TextView>(R.id.tvTemperatureMin).text =
            getString(R.string.temperature_min, state.temperatureMin)
        findViewById<TextView>(R.id.tvHumidity).text = getString(R.string.humidity, state.humidity)
    }
}