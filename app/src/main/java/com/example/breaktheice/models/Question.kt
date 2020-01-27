package com.example.breaktheice.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "questions")
data class Question(
    @SerializedName("_id") val id: String,
    val question: String,
    @SerializedName("no_of_likes") val numOfLikes: Int,
    @SerializedName("no_of_dislikes") val numOfDislikes: Int,
    val categories: List<Category>?,
    val difficulties: List<Difficulty>?
) : Parcelable
