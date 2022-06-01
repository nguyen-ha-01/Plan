package com.code.domain.usecase.task

import com.code.datalayer.entities.Task
import com.code.datalayer.repository.MainRepository
import javax.inject.Inject

class AddTask@Inject constructor(private val repository: MainRepository) {
    suspend fun invoke(task: Task){
        repository.addTask(task)
    }
}