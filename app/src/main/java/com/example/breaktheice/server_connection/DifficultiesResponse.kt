package com.example.breaktheice.server_connection

import com.example.breaktheice.models.Difficulty
import com.google.gson.annotations.SerializedName


class DifficultiesResponse {

    @SerializedName("")
    private lateinit var results : List<Difficulty>

    fun getResults() : List<Difficulty>{
        return results
    }
}
