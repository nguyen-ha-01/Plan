package com.code.datalayer.methods

import androidx.room.*
import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
@TypeConverters(Converters::class)
interface TaskDao {

    @Query("Select * from TASK_TABLE where TASK_TABLE.strategy = :strategy")
    fun taskByStrategy (strategy: String) : Flow<List<Task>>

    @Insert
    suspend fun add(task: Task)

    @Delete
    suspend fun delete(task: Task)
}