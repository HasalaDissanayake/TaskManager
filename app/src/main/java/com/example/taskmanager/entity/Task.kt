package com.example.taskmanager.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskmanager.enumeration.Category
import com.example.taskmanager.enumeration.Priority
import java.util.Date

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    val taskId: Int = 0,
    @ColumnInfo(name = "task_name")
    val taskName: String,
    @ColumnInfo(name = "task_priority")
    val taskPriority: Priority,
    @ColumnInfo(name = "task_category")
    val taskCategory: Category,
    @ColumnInfo(name = "task_note")
    val taskNote: String? = null,
    // storing filePaths as strings instead of the file to improve efficiency
    @ColumnInfo(name = "task_file")
    val taskFile: String? = null,
    @ColumnInfo(name = "task_image")
    val taskImage: String? = null,
    @ColumnInfo(name = "task_date")
    val taskDate: Date? = null,
    @ColumnInfo(name = "task_due_time")
    val dueTime: Date? = null,
    @ColumnInfo(name = "task_notification_date")
    val taskNotificationDate: Date? = null,
    @ColumnInfo(name = "task_notification_time")
    val taskNotificationTime: Date? = null,
    @ColumnInfo(name = "task_completed")
    val completed: Boolean = false

)
