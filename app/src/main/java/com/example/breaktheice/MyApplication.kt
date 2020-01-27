package com.example.breaktheice

import android.app.Application
import com.example.breaktheice.di.app_di.AppModule
import com.example.breaktheice.di.app_di.DaggerIMyApplicationComponent
import com.example.breaktheice.di.app_di.IMyApplicationComponent
import javax.inject.Singleton

@Singleton
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDagger(this)
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    private fun initDagger(myApplication: MyApplication): IMyApplicationComponent {
        return DaggerIMyApplicationComponent.builder().appModule(AppModule(myApplication)).build()
    }
}