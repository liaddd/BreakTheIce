package com.example.breaktheice.di.viewmodel_factory_di

import com.example.breaktheice.activities.SplashActivity
import com.example.breaktheice.fragments.CategoriesFragment
import dagger.Component

@Component(modules = [MyFactoryModule::class])
interface IMyFactoryComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(categoriesFragment: CategoriesFragment)
}