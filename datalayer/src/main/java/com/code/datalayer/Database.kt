package com.code.datalayer

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.code.datalayer.constant.dbName
import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task
import com.code.datalayer.methods.Converters

import com.code.datalayer.methods.StrategyDao
import com.code.datalayer.methods.TaskDao
import com.code.datalayer.methods.TimeConverter

@Database(entities = [Task::class,Strategy::class], version = 1)
@TypeConverters(Converters::class,TimeConverter::class)
abstract class Database:RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
    abstract fun getStrategyDao():StrategyDao
    companion object{
        const val db_name = dbName
    }
}