package com.example.breaktheice.models

import com.google.gson.annotations.SerializedName


data class Question(@SerializedName("id") val id: Int,
                    @SerializedName("question") val question : String,
                    @SerializedName("question") val numOfLikes : Int, val numOfDislikes: Int)
