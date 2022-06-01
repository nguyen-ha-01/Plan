package com.code.domain.usecase.strategy

import com.code.datalayer.repository.MainRepository
import javax.inject.Inject

class GetAllStrategy@Inject constructor(private val repository: MainRepository) {
    fun invoke()= repository.getAllStrategy()
}