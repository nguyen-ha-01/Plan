package com.code.plan.screens


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Snackbar
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController,modifier: Modifier = Modifier){
    val ctx = LocalContext.current

    Surface(modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
    LaunchedEffect(key1 = true){
        delay(1000)
        navController.navigate(com.code.plan.navigation.HomeScreen.name)
    }


    }

}