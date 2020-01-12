package com.example.breaktheice.models

import com.google.gson.annotations.SerializedName


data class Difficulty(@SerializedName("id") val id: Int, @SerializedName("title") val title: String)
