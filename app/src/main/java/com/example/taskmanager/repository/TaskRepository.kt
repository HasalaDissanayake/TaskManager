package com.example.taskmanager.repository

import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.entity.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun insertTask(task : Task) = taskDao.insert(task)
    suspend fun updateTask(task : Task) = taskDao.update(task)
    suspend fun deleteTask(task : Task) = taskDao.delete(task)
    fun getAllTasks() : Flow<List<Task>> = taskDao.getAllTasks()
    fun getTask(id : Int) : Flow<Task> = taskDao.getTask(id)

}