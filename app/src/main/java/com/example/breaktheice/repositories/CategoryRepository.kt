package com.example.breaktheice.repositories

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import co.climacell.statefulLiveData.core.MutableStatefulLiveData
import co.climacell.statefulLiveData.core.StatefulLiveData
import co.climacell.statefulLiveData.core.putData
import com.example.breaktheice.database.BreakTheIceDataBase
import com.example.breaktheice.database.CategoryDao
import com.example.breaktheice.models.Category
import com.example.breaktheice.server_connection.ApiRequest
import retrofit2.Retrofit


class CategoryRepository (breakTheIceDataBase: BreakTheIceDataBase , retrofit: Retrofit) {

    // todo Liad - fetch categories from Database if needed - add in production

    val categories = MutableLiveData<List<Category>>()

    private val categoryDao: CategoryDao
    private val apiRequest: ApiRequest

    init {
        Log.d("Repository initialized" , "object in memory : $this" )
        categoryDao = breakTheIceDataBase.categoryDao()
        apiRequest = retrofit.create(ApiRequest::class.java)
    }

    fun fetchCategories() : StatefulLiveData<List<Category>> {
        /*requestCategories.enqueue(object : Callback<CategoryResponse> {

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) updateCategoriesToLiveData(response.body()?.getResults())
                else {
                    toast(
                        MyApplication.instance.applicationContext,
                        response.message(),
                        2000
                    )
                }
                loading.postValue(false)
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                updateErrorCategoriesToLiveData()
                loading.postValue(false)
            }
        })*/
        val data = MutableStatefulLiveData<List<Category>>()
        Handler().postDelayed({
            data.putData(emptyList())
        } , 2000)
        return data
    }

    private fun updateCategoriesToLiveData(categoriesFetched: List<Category>?) {
        categories.postValue(categoriesFetched)
    }

    private fun updateErrorCategoriesToLiveData() {
        categories.postValue(null)
    }

}