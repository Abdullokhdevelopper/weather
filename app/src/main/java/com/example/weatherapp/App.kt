package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.di.dataModule
import com.example.weatherapp.di.networkModule
import com.example.weatherapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    networkModule,
                    presentationModule
                ))
        }
        }
        }