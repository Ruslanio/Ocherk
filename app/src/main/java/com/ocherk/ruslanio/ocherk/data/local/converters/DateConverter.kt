package com.ocherk.ruslanio.ocherk.data.local.converters

import android.arch.persistence.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    companion object {
        private val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }

    @TypeConverter
    fun dateToString(date: Date?): String? {
        if (date == null) {
            return null
        } else {
            return format.format(date)
        }
    }

    @TypeConverter
    fun stringToDate(string: String?): Date? {
        if (string == null) {
            return null
        } else {
            return format.parse(string)
        }
    }
}