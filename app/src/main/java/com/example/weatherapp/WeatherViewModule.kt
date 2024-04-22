package com.example.weatherapp

import WeatherForcastModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.RepositoryImpl
import com.example.weatherapp.weather.CurrentWeather
import kotlinx.coroutines.launch

class WeatherViewModule : ViewModel() {
    private val _weatherC: MutableLiveData<CurrentWeather> = MutableLiveData()
    val weatherC: MutableLiveData<CurrentWeather> get() = _weatherC
    private val _weatherF: MutableLiveData<WeatherForcastModel> = MutableLiveData()
    val weatherF: MutableLiveData<WeatherForcastModel> get() = _weatherF

    private val repository = RepositoryImpl()

    fun getWeather(cityName: String = "osh") = viewModelScope.launch{
        weatherC.value = repository.getCurrentWeather(cityName)
        weatherF.value =  repository.getForcastWeather(cityName)
    }
}