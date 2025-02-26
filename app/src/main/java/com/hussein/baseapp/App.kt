package com.hussein.baseapp

import android.app.Application
import com.hussein.baseapp.di.appModule
import com.hussein.baseapp.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, dataModule)
        }
    }
}