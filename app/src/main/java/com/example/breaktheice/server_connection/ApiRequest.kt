package com.example.breaktheice.server_connection

import co.climacell.statefulLiveData.core.StatefulLiveData
import retrofit2.http.GET

interface ApiRequest {

    @GET("categories")
    fun getCategories(): StatefulLiveData<CategoryResponse>

    @GET("questions")
    fun getQuestions(): StatefulLiveData<QuestionsResponse>

}