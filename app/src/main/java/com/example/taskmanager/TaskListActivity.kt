package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.taskmanager.entity.Task
import com.example.taskmanager.enumeration.Category
import com.example.taskmanager.enumeration.Priority
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TaskListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        // to access Db related queries
        val app = applicationContext as TaskManagerApplication
        Log.d("App", "Initialized $app")

        val testTask = Task(
            taskName = "Test Task",
            taskPriority = Priority.LOW,
            taskCategory = Category.HEALTH
        )

        val testTasknew = Task(
            taskName = "Test Task new",
            taskPriority = Priority.HIGH,
            taskCategory = Category.EDUCATION
        )

        try {
            lifecycleScope.launch {
                app.taskRepository.insertTask(testTask)
                app.taskRepository.insertTask(testTasknew)
                val tasks = app.taskRepository.getAllTasks().first()
                Log.d("TaskListActivity", "Number of tasks in the database: ${tasks.size}")

                tasks.forEachIndexed { index, task ->
                    Log.d("TaskListActivity", "Task $index: $task")
                }
            }
        } catch (e: Exception) {
            Log.e("DatabaseInsertError", "Error inserting task into the database: $e")
        }
    }
}