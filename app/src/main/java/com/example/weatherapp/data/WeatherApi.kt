package com.example.weatherapp.data

import Weather
import WeatherForcastModel
import com.example.weatherapp.data.Utils.APP_ID
import com.example.weatherapp.weather.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(Endpoints.CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("units") unit: String= "metric",
        @Query("appid") appId: String= APP_ID
    ): Response<CurrentWeather>

    @GET(Endpoints.WEATHER_FORCAST)
    suspend fun getForcastWeather(
        @Query("q") cityName: String,
        @Query("units") unit: String= "metric",
        @Query("appid") appId: String= APP_ID
    ): Response<WeatherForcastModel>

}