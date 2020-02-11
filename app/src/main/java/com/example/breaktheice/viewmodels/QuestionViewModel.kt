package com.example.breaktheice.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.breaktheice.models.Question
import com.example.breaktheice.repositories.CategoryRepository

class QuestionViewModel(val categoryRepository: CategoryRepository) : ViewModel() {



    //TODO("not implemented")
    fun getQuestions(categoryId: String, difficultyId: String): LiveData<List<Question>> = categoryRepository.getQuestions()
}