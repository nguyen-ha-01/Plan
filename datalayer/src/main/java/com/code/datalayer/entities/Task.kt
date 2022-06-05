package com.code.datalayer.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.code.datalayer.component.DateK
import com.code.datalayer.constant.*
import java.time.LocalDate
import java.time.LocalTime

import java.util.*
import kotlin.time.Duration
//time by iso
@Entity(tableName = taskTableName)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    var title : String,
    var strategy : String ,
    var positionInStrategy : Int = 0,
    var timeLong: String,
    var start :LocalDate?,
    var end :  LocalDate?,
    var requite: LocalTime?,
    var timeDone: LocalTime?
){

}

