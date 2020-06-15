package com.example.breaktheice.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import co.climacell.statefulLiveData.core.*
import com.example.breaktheice.database.BreakTheIceDataBase
import com.example.breaktheice.database.CategoryDao
import com.example.breaktheice.models.Category
import com.example.breaktheice.models.Question
import com.example.breaktheice.server_connection.ApiRequest
import retrofit2.Retrofit
import java.util.concurrent.Executors


class CategoryRepository(breakTheIceDataBase: BreakTheIceDataBase, retrofit: Retrofit) {

    val categories: StatefulLiveData<List<Category>>

    private val dao: CategoryDao
    private val apiRequest: ApiRequest
    private val executor = Executors.newSingleThreadExecutor()

    init {
        Log.d("Repository initialized", "object in memory : $this")
        dao = breakTheIceDataBase.categoryDao()
        apiRequest = retrofit.create(ApiRequest::class.java)

        categories = getCategoriesStatefulLiveData()
    }

    private fun getCategoriesStatefulLiveData(): StatefulLiveData<List<Category>> {

        val categories = MutableStatefulLiveData<List<Category>>()
        categories.putLoading()

        getCategoriesFromDatabase().observeOnce(Observer { dbCategories ->
            if (dbCategories.isNullOrEmpty()) {
                getCategoriesFromApi().observeOnce(Observer { apiCategories ->
                    if (apiCategories is StatefulData.Success) {
                        val categoriesFetched = apiCategories.data.getCategories()
                        Log.d("Liad", categoriesFetched.toString())
                        categories.putData(categoriesFetched)
                        saveCategoriesInDatabase(categoriesFetched)
                    }
                })
            } else {
                categories.putData(dbCategories)
            }
        })
        return categories
    }

    private fun saveCategoriesInDatabase(categories: List<Category>) {
        executor.submit {
            val value = dao.insertAll(categories)
            Log.d("Liad", "value: $value")
        }
    }

    private fun getCategoriesFromDatabase(): LiveData<List<Category>> = dao.getAllCategories()

    private fun getCategoriesFromApi() = apiRequest.getCategories()

    fun getQuestions(): LiveData<List<Question>> {
        // todo ("not implemented")
        val questions = MutableLiveData<List<Question>>()

        return questions
    }

}