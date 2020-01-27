package com.example.breaktheice.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breaktheice.models.Question

class QuestionViewModel : ViewModel() {


    fun getQuestions(categoryId: String, difficultyId: String): LiveData<List<Question>> {
        return MutableLiveData<List<Question>>()
    }

}