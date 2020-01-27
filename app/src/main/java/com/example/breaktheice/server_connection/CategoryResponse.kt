package com.example.breaktheice.server_connection

import com.example.breaktheice.models.Category
import com.google.gson.annotations.SerializedName

class CategoryResponse {

    @SerializedName("categories")
    private var results: List<Category> = listOf()

    fun getResults(): List<Category> {
        return results
    }

}