package com.example.breaktheice.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breaktheice.models.Category
import com.example.breaktheice.server_connection.CategoryResponse
import com.example.breaktheice.server_connection.RetrofitProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StartFragmentViewModel : ViewModel() {

    private val categories: MutableLiveData<List<Category>> by lazy {
        MutableLiveData<List<Category>>().also {
            loadCategories()
        }
    }

    fun getCategories(): LiveData<List<Category>> {
        return categories
    }

    private fun loadCategories() {
        RetrofitProvider.instance.getCategories().enqueue(object : Callback<CategoryResponse>{
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                Log.d("VIEWMODEL" , "response.body().getResults() ${response.body()!!.getResults()}")
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
               Log.d("VIEWMODEL" , t.message)
            }

        })
    }
}