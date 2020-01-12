package com.example.breaktheice.server_connection

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("questions")
    fun getQuestions(): Call<QuestionsResponse>

    @GET("categories")
    fun getCategories(): Call<CategoryResponse>

    @GET("difficulties")
    fun getDifficulties(): Call<DifficultiesResponse>

}