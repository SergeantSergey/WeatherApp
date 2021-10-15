package com.example.weatherapp

import com.example.weatherapp.feature.weather_screen.data.api.WeatherRepo
import java.math.BigDecimal

class MockWeatherRepo : WeatherRepo {

    companion object {
        const val DEFAULT_WEATHER = "В Москве сегодня солнечно"
        const val EMPTY_WEATHER = ""
    }

    private val weatherYandex = hashMapOf(
        "Zurich" to BigDecimal("-11.3"),
        "Tokyo" to BigDecimal("15"),
        "New York" to BigDecimal("0"),
        "London" to BigDecimal("-7"),
        "Paris" to BigDecimal("15.1"),
        "Moscow" to BigDecimal("25.6")
    )


    override fun getWeather() = weatherYandex
        .filter {
            it.value > BigDecimal.ZERO
        }.map { (city, temperature) ->
            "В $city температура сегодня $temperature градусов"
        }.joinToString(
            separator = "\n"
        )
}