package com.code.datalayer.constant

import android.util.TimeUtils
import com.code.datalayer.component.DateK
import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task
import java.sql.Time
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.chrono.ChronoLocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.TimeMark
import kotlin.time.TimedValue

val s= LocalDate.parse("30/05/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
val dateDf   =    s
val startDf =     s
val endDf =       s
val requireDf =   LocalTime.parse("03:30:00", DateTimeFormatter.ISO_TIME)
val doneDf =      LocalTime.parse("03:30:00", DateTimeFormatter.ISO_TIME)
val strategyDf : Strategy = Strategy(null,"android leaning",50f)
val taskDf : Task = Task(null,"learn compose ui" , strategyDf.name,0, dateDf.toString(), startDf, endDf, requireDf,doneDf)
val taskDf1 : Task = Task(null,"learn compose ui" , strategyDf.name,0, dateDf.toString(),startDf, endDf, requireDf,doneDf)