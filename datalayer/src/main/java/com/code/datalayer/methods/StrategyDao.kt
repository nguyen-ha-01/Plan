package com.code.datalayer.methods

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.code.datalayer.entities.Strategy
import kotlinx.coroutines.flow.Flow

@Dao
interface StrategyDao {
    @Query("select * from STRATEGY_TABLE")
    fun getAllStrategy(): Flow<List<Strategy>>

    @Insert
    suspend fun add(strategy: Strategy)
    @Delete
    suspend fun delete(strategy: Strategy)

}