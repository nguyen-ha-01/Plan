package com.code.domain.usecase.task

import com.code.datalayer.entities.Strategy
import com.code.datalayer.repository.MainRepository
import javax.inject.Inject

class TasksByStrategy @Inject constructor(private val repository: MainRepository) {
    fun invoke(strategy: String) = repository.taskByStrategy(strategy)
}