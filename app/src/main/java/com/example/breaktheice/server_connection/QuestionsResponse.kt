package com.example.breaktheice.server_connection

import com.example.breaktheice.models.Question
import com.google.gson.annotations.SerializedName


class QuestionsResponse {

    @SerializedName("")
    private lateinit var results: List<Question>

    fun getResults(): List<Question> {
        return results
    }
}
