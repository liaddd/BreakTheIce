package com.example.breaktheice.di.viewmodel_factory_di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class MyFactoryModule {

    @Provides
    fun providesViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory = factory

}