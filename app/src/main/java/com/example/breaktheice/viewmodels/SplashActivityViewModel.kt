package com.example.breaktheice.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.climacell.statefulLiveData.core.StatefulLiveData
import com.example.breaktheice.models.Category
import com.example.breaktheice.repositories.CategoryRepository

class SplashActivityViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    fun loadCategories() : StatefulLiveData<List<Category>> = categoryRepository.fetchCategories()

    fun getCategoriesLiveData(): LiveData<List<Category>> = categoryRepository.categories


}