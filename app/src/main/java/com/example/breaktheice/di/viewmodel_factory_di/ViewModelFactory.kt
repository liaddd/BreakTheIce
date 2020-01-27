package com.example.breaktheice.di.viewmodel_factory_di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.breaktheice.viewmodels.SplashActivityViewModel
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val myViewModel: Provider<SplashActivityViewModel>
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            SplashActivityViewModel::class.java -> myViewModel.get()
            else -> TODO("missing class $modelClass")
        } as T
    }

}