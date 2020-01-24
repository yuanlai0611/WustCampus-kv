package com.example.wustcampus.datasource.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wustcampus.datasource.db.dao.CourseDao
import com.example.wustcampus.datasource.db.dao.UserDao
import com.example.wustcampus.datasource.db.databean.CourseBean
import com.example.wustcampus.datasource.db.databean.UserBean
import com.example.wustcampus.datasource.db.databean.WeekBean

@Database(entities = [CourseBean::class, UserBean::class, WeekBean::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun courseDao(): CourseDao

    companion object {
        @Volatile
        var instance: AppDatabase? = null


        fun getInstance(ctx: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(ctx).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(ctx: Context): AppDatabase {
            return Room
                .databaseBuilder(ctx, AppDatabase::class.java, "WustCampus_database")
                .build()
        }
    }
}