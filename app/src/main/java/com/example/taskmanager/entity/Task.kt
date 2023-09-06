package com.example.taskmanager.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskmanager.enumeration.Category
import com.example.taskmanager.enumeration.Priority
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    val taskId: Int,
    @ColumnInfo(name = "task_name")
    val taskName: String,
    @ColumnInfo(name = "task_priority")
    val taskPriority: Priority?,
    @ColumnInfo(name = "category")
    val taskCategory: Category?,
    @ColumnInfo(name = "task_note")
    val taskNote: String?,
    // storing filePaths as strings instead of the file to improve efficiency
    @ColumnInfo(name = "task_file")
    val taskFile: String?,
    @ColumnInfo(name = "task_image")
    val taskImage: String?,
    @ColumnInfo(name = "task_date")
    val taskDate: LocalDate?,
    @ColumnInfo(name = "task_due_time")
    val dueTime: LocalTime?,
    @ColumnInfo(name = "task_notification_date")
    val taskNotificationDate: LocalDate?,
    @ColumnInfo(name = "task_notification_time")
    val taskNotificationTime: LocalTime?,
    @ColumnInfo(name = "task_completed")
    val completed: Boolean = false

)
