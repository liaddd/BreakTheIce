package com.example.breaktheice.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey @SerializedName("_id") val id: String,
    val question: String,
    @SerializedName("no_of_likes") val numOfLikes: Int,
    @SerializedName("no_of_dislikes") val numOfDislikes: Int
)
