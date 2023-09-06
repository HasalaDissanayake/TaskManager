package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskmanager.database.TaskDatabase
import com.example.taskmanager.repository.TaskRepository

class TaskListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        // Initialized the Database here (need to rethink this implementation)
        val database = TaskDatabase.getDatabase(this)
        val taskDao = database.taskDao()
        val taskRepository = TaskRepository(taskDao)

        taskRepository.getAllTasks()
    }
}