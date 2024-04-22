package com.example.weatherapp.di

import Weather
import com.example.weatherapp.WeatherViewModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{
        WeatherViewModule(
        )

    }
}