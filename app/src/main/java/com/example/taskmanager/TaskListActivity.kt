package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.taskmanager.database.TaskDatabase
import com.example.taskmanager.entity.Task
import com.example.taskmanager.enumeration.Category
import com.example.taskmanager.enumeration.Priority
import com.example.taskmanager.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        // Initialized the Database here (need to rethink this implementation)
        val database = TaskDatabase.getDatabase(this)
        val taskDao = database.taskDao()
        val taskRepository = TaskRepository(taskDao)

        val testTask = Task(
            taskId = 1,
            taskName = "Test Task",
            taskPriority = Priority.LOW,
            taskCategory = Category.HEALTH
        )

        lifecycleScope.launch {
            taskRepository.insertTask(testTask)
        }
    }
}