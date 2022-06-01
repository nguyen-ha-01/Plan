package com.code.plan.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.datalayer.component.strategyState
import com.code.datalayer.component.taskState
import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task
import com.code.domain.usecase.strategy.AddStrategy
import com.code.domain.usecase.strategy.DeleteStrategy
import com.code.domain.usecase.strategy.GetAllStrategy
import com.code.domain.usecase.task.AddTask
import com.code.domain.usecase.task.DeleteTask
import com.code.domain.usecase.task.TasksByStrategy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addStrategy :AddStrategy,
    private val deleteStrategy: DeleteStrategy,
    private val getAllStrategy: GetAllStrategy,
    private val addTask: AddTask,
    private val deleteTask: DeleteTask,
    private val tasksByStrategy: TasksByStrategy
):ViewModel() {
    //note: task here is taken by strategy
    val _tasks :MutableState<taskState> = mutableStateOf(taskState())
    val tasks : State<taskState> = _tasks

    val _strategies :MutableState<strategyState> = mutableStateOf(strategyState())
    val strategies : State<strategyState> = _strategies
    init {
        getAllStrategy.invoke().onEach { list->
            _strategies.value = strategies.value.copy(list)
        }.launchIn(viewModelScope)
    }
    fun getTaskByStrategy(strategy: String) = tasksByStrategy.invoke(strategy).onEach { list->
        _tasks.value = tasks.value.copy(list)
    }.launchIn(viewModelScope)

    fun addStrategy(strategy:Strategy) = viewModelScope.launch(Dispatchers.IO) {addStrategy.invoke(strategy)}
    fun deleteStrategy(strategy: Strategy) = viewModelScope.launch(Dispatchers.IO) { deleteStrategy.invoke(strategy) }
    fun addTask (task: Task) =viewModelScope.launch (Dispatchers.IO){addTask.invoke(task)}
    fun  deleteTask (task: Task) = viewModelScope.launch (Dispatchers.IO){deleteTask.invoke(task)}

}

internal fun MainViewModel.bla(){

}