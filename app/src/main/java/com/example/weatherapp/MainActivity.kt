package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.feature.city_screen.ui.CityScreenActivity
import com.example.weatherapp.feature.weather_screen.ui.WeatherScreenActivity
import com.example.weatherapp.feature.wind_screen.ui.WindScreenActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val weatherButton = findViewById<Button>(R.id.weatherButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        val windButton = findViewById<Button>(R.id.windButton)

        weatherButton.setOnClickListener {
            Intent(this, WeatherScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        settingsButton.setOnClickListener {
            Intent(this, CityScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        windButton.setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}