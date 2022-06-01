package com.code.datalayer.repository

import androidx.room.Delete
import androidx.room.Insert
import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task
import com.code.datalayer.methods.StrategyDao
import com.code.datalayer.methods.TaskDao
import kotlinx.coroutines.flow.Flow

class MainRepository (private val taskDao: TaskDao, private val strategyDao: StrategyDao) {
    fun getAllStrategy(): Flow<List<Strategy>> = strategyDao.getAllStrategy()

    suspend fun addStrategy(strategy: Strategy) = strategyDao.add(strategy)

    suspend fun deleteStrategy(strategy: Strategy) = strategyDao.delete(strategy)

    fun taskByStrategy (strategy: String) : Flow<List<Task>> = taskDao.taskByStrategy(strategy)

    suspend fun addTask(task: Task) = taskDao.add(task)

    suspend fun deleteTask(task: Task) = taskDao.delete(task)
}