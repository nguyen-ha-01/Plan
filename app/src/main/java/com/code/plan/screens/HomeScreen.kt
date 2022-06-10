package com.code.plan.screens

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.code.plan.activities.act2.Activity2
import com.code.plan.component.ScaffoldScreen
import com.code.plan.navigation.activity2

@Composable
fun HomeScreen(navController: NavHostController,modifier: Modifier = Modifier ){

    navController.enableOnBackPressed(true)

    Surface(modifier = modifier.fillMaxWidth()) {
        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                navController.navigate(activity2.name)
            }) {
                Text("move to act2")
            }
        }

    }
}
//
//@Composable
//fun HandleBackPress(){
//    val backPressCallBack by remember{
//        BackHandler() {
//
//        }
//    }
//    val backPressDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current)
//    {"there's no back Press provided"}.onBackPressedDispatcher
//    val lifecycle = LocalLifecycleOwner.current.lifecycle
//    backPressDispatcher.onBackPressed()
//}