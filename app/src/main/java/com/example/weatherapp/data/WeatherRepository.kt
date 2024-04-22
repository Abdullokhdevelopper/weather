package com.example.weatherapp.data

import WeatherForcastModel
import com.example.weatherapp.weather.CurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(cityName: String):CurrentWeather
    suspend fun getForcastWeather(cityName: String):WeatherForcastModel
}
