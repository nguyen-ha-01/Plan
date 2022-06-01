package com.code.plan.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.code.datalayer.constant.strategyDf
import com.code.datalayer.constant.taskDf
import com.code.plan.component.ItemTask
import com.code.plan.ui.theme.PlanTheme
import com.code.plan.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject
import kotlin.time.Duration
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var  mainviewmodel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
//                    mainviewmodel.addTask(taskDf)
//                    mainviewmodel.addStrategy(strategyDf)
                    ItemTask()




                }
            }
        }
    }
}
