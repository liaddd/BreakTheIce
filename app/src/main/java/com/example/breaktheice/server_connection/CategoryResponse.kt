package com.example.breaktheice.server_connection

import com.example.breaktheice.models.Category
import com.google.gson.annotations.SerializedName

class CategoryResponse {


    @SerializedName("")
    private lateinit var results: List<Category>

    fun getResults(): List<Category> {
        return results
    }

}