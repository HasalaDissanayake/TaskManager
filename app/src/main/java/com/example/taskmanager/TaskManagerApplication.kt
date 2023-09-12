package com.example.taskmanager

import android.app.Application
import android.util.Log
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.database.TaskDatabase
import com.example.taskmanager.repository.TaskRepository

class TaskManagerApplication : Application() {

    lateinit var taskDao: TaskDao
    lateinit var taskRepository: TaskRepository

    override fun onCreate() {
        super.onCreate()

        // Initialize the database, DAO, and repository here ( So Can be accessed globally in any activity)
        val database = TaskDatabase.getDatabase(this)
        Log.d("Database", "DB initialized $database")
        taskDao = database.taskDao()
        Log.d("TaskDao", "TaskDao initialized $taskDao")
        taskRepository = TaskRepository(taskDao)
        Log.d("TaskRepository", "TaskRepository initialized $taskRepository")
    }

}