package com.code.domain.component

import android.util.Log
import com.code.datalayer.component.DateK
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ISO_DATE_TIME
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
import java.util.*

object Trans {
    fun stringToDate(localdatetime:String):DateK{
        val convert = LocalDateTime.parse(localdatetime)
        return DateK(convert.year,convert.monthValue,convert.dayOfMonth,convert.hour,convert.minute,convert.second)
    }
}