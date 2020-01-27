package com.example.breaktheice.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.breaktheice.models.Category

@Dao
interface CategoryDao {

    @Insert
    fun insert(category: Category)

    @Insert
    fun insertAll(categories: List<Category>)

    @Delete
    fun delete(category: Category)

    @Update
    fun update(category: Category)

    @Query("DELETE FROM categories")
    fun deleteAllCategories()

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>
}