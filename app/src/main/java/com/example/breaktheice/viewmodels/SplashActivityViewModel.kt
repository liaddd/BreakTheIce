package com.example.breaktheice.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.breaktheice.models.Category
import com.example.breaktheice.repositories.CategoryRepository
import javax.inject.Inject

class SplashActivityViewModel @Inject constructor(private val categoryRepository: CategoryRepository) : ViewModel() {

    fun loadCategories() = categoryRepository.fetchCategories()

    fun getCategoriesLiveData(): LiveData<List<Category>> = categoryRepository.categories

    fun getIsLoading(): LiveData<Boolean> {
        return categoryRepository.getIsLoading()
    }

}