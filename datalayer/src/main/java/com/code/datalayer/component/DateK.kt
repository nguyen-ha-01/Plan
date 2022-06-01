package com.code.datalayer.component

import java.util.*

data class DateK(
    val year : Int,
    val month : Int,
    val day : Int,
    val hour : Int,
    val minute : Int = 0,
    val second : Int  =0
){
    fun toCalenderTime() = Date(year,month,day,hour,minute,second).time
    fun toDay(): Int = year*365+ month*30
    fun toHour():Int = toDay()*24 + hour + minute/60
    fun toMinute() = toHour()*60
    fun toSecond():Int = toMinute()*60
}
