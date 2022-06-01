package com.code.datalayer.constant

import android.util.TimeUtils
import com.code.datalayer.component.DateK
import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task
import java.sql.Time
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.chrono.ChronoLocalDate
import java.util.*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.TimeMark
import kotlin.time.TimedValue

val s= LocalDateTime.parse("2022-05-30T04:08").toString()
val dateDf   =    s
val startDf =     s
val endDf =       s
val requireDf =   s
val doneDf =      s
val strategyDf : Strategy = Strategy(null,"android leaning",50f)
val taskDf : Task = Task(null,"learn compose ui" , strategyDf.name,0, dateDf.toString(), startDf.toString(), endDf.toString(), requireDf.toString(),doneDf.toString())
val taskDf1 : Task = Task(null,"learn compose ui" , strategyDf.name,0, dateDf.toString(),startDf.toString(), endDf.toString(), requireDf.toString(),doneDf.toString())