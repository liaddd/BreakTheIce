package com.example.breaktheice.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.breaktheice.MyApplication
import com.example.breaktheice.models.Category
import com.example.breaktheice.server_connection.CategoriesApi
import com.example.breaktheice.server_connection.CategoryResponse
import com.example.breaktheice.services.ServiceBuilder
import com.example.breaktheice.utils.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class CategoryRepository @Inject constructor() {

    // todo Liad - fetch categories from Database if needed - add in production
    //private var categoryDao: CategoryDao
    private val loading = MutableLiveData<Boolean>()
    val categories = MutableLiveData<List<Category>>()
    private var categoryService: CategoriesApi = ServiceBuilder.buildService(CategoriesApi::class.java)

    /*init {
        val breakTheIceDataBase: BreakTheIceDataBase = BreakTheIceDataBase.getDatabase(MyApplication.instance)
        categoryDao = breakTheIceDataBase.categoryDao()
        categories.postValue(categoryDao.getAllCategories().value)
        if (categories.value.isNullOrEmpty()) {
            getCategoriesLiveData()
        }
    }*/

    init{
        Log.d("Repository initialized" , "object in memory : $this" )
    }

    fun fetchCategories() {
        loading.postValue(true)
        val requestCategories = categoryService.getCategories()
        requestCategories.enqueue(object : Callback<CategoryResponse> {

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) updateCategoriesToLiveData(response.body()?.getResults())
                else {
                    Toast(MyApplication.instance.applicationContext, response.message(), 2000)
                }
                loading.postValue(false)
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                updateErrorCategoriesToLiveData()
                loading.postValue(false)
            }
        })
    }

    private fun updateCategoriesToLiveData(categoriesFetched: List<Category>?) {
        categories.postValue(categoriesFetched)
    }

    private fun updateErrorCategoriesToLiveData() {
        categories.postValue(null)
    }

    fun getIsLoading(): LiveData<Boolean> {
        return loading
    }


}