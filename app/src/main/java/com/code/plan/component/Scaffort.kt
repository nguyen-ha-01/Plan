package com.code.plan.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ScaffoldScreen(navHostController: NavHostController,modifier: Modifier = Modifier ,
                   scaffoldState: ScaffoldState = rememberScaffoldState(),
                   topBar: @Composable () -> Unit = {},
                   bottomBar: @Composable () -> Unit = {},
                   content: @Composable (PaddingValues)-> Unit = {}){
    Scaffold(modifier,scaffoldState,topBar,bottomBar,){ it->
        content(it)
    }
}