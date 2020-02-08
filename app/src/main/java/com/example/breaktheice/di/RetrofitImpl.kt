package com.example.breaktheice.di

import co.climacell.statefulLiveData.retrofit.StatefulLiveDataCallAdapterFactory
import com.example.breaktheice.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(StatefulLiveDataCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}