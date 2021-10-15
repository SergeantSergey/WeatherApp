package com.example.weatherapp

import org.junit.Assert
import org.junit.Test

class WeatherRepoTest {

    @Test
    fun testWeather() {
        val mockWeatherRepo = MockWeatherRepo()
        val weather = mockWeatherRepo.getWeather()
        println(weather)
        Assert.assertTrue(weather.isNotEmpty())
    }
}