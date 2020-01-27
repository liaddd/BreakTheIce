package com.example.breaktheice.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "categories")
data class Category(
    @PrimaryKey @SerializedName("_id") val id: String, val key: String,
    val difficulties: List<Difficulty>
) : Parcelable