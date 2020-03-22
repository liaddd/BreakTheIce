package com.example.breaktheice.viewmodels

import androidx.lifecycle.ViewModel
import co.climacell.statefulLiveData.core.StatefulLiveData
import com.example.breaktheice.models.Category
import com.example.breaktheice.repositories.CategoryRepository

class CategoriesViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    fun getCategories(): StatefulLiveData<List<Category>> = categoryRepository.categories
}