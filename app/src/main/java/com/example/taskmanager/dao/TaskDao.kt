package com.example.taskmanager.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanager.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    // suspend is used as db queries can take longer time so it should execute in a different thread. (Room doesn't allow db access on the main thread)
    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    // Flow is recommended to use as it will keep updated whenever a database change occurs
    @Query("SELECT * from tasks")
    fun getAllTasks() : Flow<List<Task>>

    @Query("SELECT * from tasks WHERE taskId = :id")
    fun getTask(id: Int) : Flow<Task>

}