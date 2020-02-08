package com.example.breaktheice.di

import com.example.breaktheice.MyApplication
import com.example.breaktheice.database.BreakTheIceDataBase
import com.example.breaktheice.repositories.CategoryRepository
import com.example.breaktheice.viewmodels.QuestionViewModel
import com.example.breaktheice.viewmodels.SplashActivityViewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of Retrofit
    single { RetrofitImpl().getRetrofit() }

    // single instance of Database
    single { BreakTheIceDataBase.getDatabase(MyApplication.instance) }

    // single instance of Repository
    single { CategoryRepository(get(), get()) }

    factory { SplashActivityViewModel(get()) }
    factory { QuestionViewModel(get()) }
}