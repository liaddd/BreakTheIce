package com.example.breaktheice.database

import androidx.room.TypeConverter
import com.example.breaktheice.models.Difficulty
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    // difficulty converter
    @TypeConverter
    fun stringToDifficulty(data: String?): List<Difficulty> = Gson().fromJson(data, object: TypeToken<List<Difficulty>>(){}.type)

    @TypeConverter
    fun difficultyToString(difficulty: Difficulty): String = Gson().toJson(difficulty)
}