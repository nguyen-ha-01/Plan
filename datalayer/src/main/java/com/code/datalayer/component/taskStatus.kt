package com.code.datalayer.component

import com.code.datalayer.entities.Strategy
import com.code.datalayer.entities.Task

data class taskState(val values : List<Task> = emptyList())
data class strategyState (val values : List<Strategy> = emptyList())
