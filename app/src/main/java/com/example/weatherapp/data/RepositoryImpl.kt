package com.example.weatherapp.data

import WeatherForcastModel
import com.example.weatherapp.weather.CurrentWeather

class RepositoryImpl: WeatherRepository {

    private val api = RetrofitInstance.api

    override suspend fun getCurrentWeather(cityName: String) : CurrentWeather {
        return api.getCurrentWeather(cityName = cityName).body()!!
    }


    override suspend fun getForcastWeather(cityName: String):WeatherForcastModel =
        api.getForcastWeather(cityName = cityName).body()!!

}