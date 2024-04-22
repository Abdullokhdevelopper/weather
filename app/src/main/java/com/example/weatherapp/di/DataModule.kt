package com.example.weatherapp.di

import com.example.weatherapp.data.RepositoryImpl
import com.example.weatherapp.data.WeatherRepository
import org.koin.dsl.module


val dataModule = module {
    single<WeatherRepository>{
        RepositoryImpl()
    }

}