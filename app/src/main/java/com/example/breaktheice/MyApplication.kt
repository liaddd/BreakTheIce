package com.example.breaktheice

import android.app.Application
import com.example.breaktheice.di.appModule
import org.koin.core.context.startKoin

class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            modules(listOf(appModule))
        }
    }


}