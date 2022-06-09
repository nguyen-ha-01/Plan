package com.code.plan.activities

import android.content.Context
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.code.datalayer.constant.strategyDf
import com.code.datalayer.constant.taskDf
import com.code.plan.R
import com.code.plan.component.ItemTask
import com.code.plan.navigation.NavHost
import com.code.plan.ui.theme.BackgroundColor
import com.code.plan.ui.theme.PlanTheme
import com.code.plan.viewmodel.MainViewModel
import com.code.plan.viewmodel.getDir
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
//        actionBar?.hide()
        setContent {
            PlanTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor) {
                    Column() {
                        NavHost()
                    }
                }
            }
        }
    }
}
