package com.code.domain.usecase.strategy

import com.code.datalayer.entities.Strategy
import com.code.datalayer.repository.MainRepository
import javax.inject.Inject

class AddStrategy@Inject constructor(private val repository: MainRepository) {
    suspend fun invoke(strategy: Strategy) = try {
        repository.addStrategy(strategy)
    }catch (e:Exception){
        
    }
}

