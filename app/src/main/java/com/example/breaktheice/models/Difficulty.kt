package com.example.breaktheice.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "difficulties")
data class Difficulty(@PrimaryKey @SerializedName("_id") val id: String, val key: String)