package com.example.breaktheice.di.app_di

import com.example.breaktheice.MyApplication
import com.example.breaktheice.repositories.CategoryRepository
import com.example.breaktheice.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val app: MyApplication) {

    @Provides
    @Singleton
    fun provideContext(): MyApplication = app

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

    @Singleton
    @Provides
    fun provideRetrofitInstance(gson: Gson, client: OkHttpClient): Retrofit.Builder {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
    }

    @Singleton
    @Provides
    fun provideCategoryRepository(categoryRepository: CategoryRepository) : CategoryRepository = categoryRepository
}