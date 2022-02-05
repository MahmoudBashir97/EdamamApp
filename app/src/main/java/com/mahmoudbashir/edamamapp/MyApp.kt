package com.mahmoudbashir.edamamapp

import android.app.Application
import com.mahmoudbashir.edamamapp.koin.apiModule
import com.mahmoudbashir.edamamapp.koin.mainViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                apiModule,
                mainViewModelModule
            )
        }
    }
}