package com.example.taskmanager.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskmanager.enumeration.Category
import com.example.taskmanager.enumeration.Priority
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    val taskId: Int,
    val taskPriority: Priority,
    val taskCategory: Category,
    val taskNote: String,
    // storing filePaths as strings instead of the file to improve efficiency
    val taskFile: String,
    val taskImage: String,
    val taskDate: LocalDate,
    val dueTime: LocalTime,
    val taskNotificationDate: LocalDate,
    val taskNotificationTime: LocalTime,
    val completed: Boolean

)
