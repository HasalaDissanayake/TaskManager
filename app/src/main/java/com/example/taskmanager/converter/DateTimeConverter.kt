package com.example.taskmanager.converter

import androidx.room.TypeConverter
import java.util.Date

// needed this because room don't support for Data type
class DateTimeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}