package com.example.breaktheice.di.app_di

import com.example.breaktheice.di.viewmodel_factory_di.MyFactoryModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class , MyFactoryModule::class])
interface IMyApplicationComponent