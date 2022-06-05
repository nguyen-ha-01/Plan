package com.code.datalayer.methods

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import kotlin.time.Duration
import kotlin.time.DurationUnit

@ProvidedTypeConverter
class Converters{
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDate? {
        return LocalDate.parse(value)
    }
    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): String?{
        return date.toString()
    }
}
@ProvidedTypeConverter
class TimeConverter{
    @TypeConverter
    fun localTimeToString(duration: LocalTime?):String?{
        return duration.toString()
    }
    @TypeConverter
    fun stringToLocalTime(value:String?):LocalTime?{
        return LocalTime.parse(value)
    }
}