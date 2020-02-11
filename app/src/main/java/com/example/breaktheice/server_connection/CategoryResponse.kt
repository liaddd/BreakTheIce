package com.example.breaktheice.server_connection

import com.example.breaktheice.models.Category
import com.google.gson.annotations.SerializedName

class CategoryResponse {

    @SerializedName("categories")
    private var categories: List<Category> = listOf()

    fun getCategories(): List<Category> = categories

}