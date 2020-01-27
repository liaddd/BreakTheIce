package com.example.breaktheice.server_connection

import retrofit2.Call
import retrofit2.http.GET

interface QuestionsApi {

    @GET("questions")
    fun getQuestions(): Call<QuestionsResponse>

}