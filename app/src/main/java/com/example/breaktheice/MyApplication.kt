package com.example.breaktheice

import android.app.Application
import com.example.breaktheice.di.appModule
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            modules(listOf(appModule))
        }
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }

}