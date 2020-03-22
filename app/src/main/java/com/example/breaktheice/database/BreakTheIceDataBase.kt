package com.example.breaktheice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.breaktheice.models.Category
import com.example.breaktheice.models.Difficulty
import com.example.breaktheice.models.Question


@Database(
    entities = [Category::class, Difficulty::class, Question::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class BreakTheIceDataBase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {

        @Volatile
        private var instance: BreakTheIceDataBase? = null

        fun getDatabase(context: Context): BreakTheIceDataBase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                return Room.databaseBuilder(
                        context.applicationContext,
                        BreakTheIceDataBase::class.java,
                        "breakTheIce.db"
                    ).fallbackToDestructiveMigration()
                    .build()
            }
        }

    }
}