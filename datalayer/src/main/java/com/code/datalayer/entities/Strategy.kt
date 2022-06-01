package com.code.datalayer.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.code.datalayer.constant.strategyTableName
import com.code.datalayer.constant.taskTableName

@Entity(tableName = strategyTableName,indices = [Index (value = ["name"],unique = true)])
data class Strategy(
    @PrimaryKey(autoGenerate = true)
    var id : Int? ,
    @ColumnInfo(name = "name")
    val name : String,
    val status : Float = 0.0f
)
