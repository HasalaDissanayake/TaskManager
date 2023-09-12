package com.example.taskmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taskmanager.converter.DateTimeConverter
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.entity.Task

// If any changes done to entity version needs to incremented
@Database(entities = [Task::class], version = 4, exportSchema = false)
@TypeConverters(DateTimeConverter::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object {
        // volatile means this can be accessed by many threads and changes will be visible immediately to all threads
        @Volatile
        private var Instance: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            // If instance null create it, else return it
            // to make sure only single thread at a time can execute this block synchronized used
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}