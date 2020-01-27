package com.example.breaktheice.server_connection

import retrofit2.Call
import retrofit2.http.GET

interface CategoriesApi {

    @GET("categories")
    fun getCategories(): Call<CategoryResponse>
}