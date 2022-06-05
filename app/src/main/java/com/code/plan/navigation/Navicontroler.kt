package com.code.plan.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.code.plan.screens.HomeScreen
import com.code.plan.screens.SplashScreen
import java.util.concurrent.CompletionService


@Composable
fun NavHost(navHostController: NavHostController = rememberNavController()){
    NavHost(navController = navHostController, startDestination = SplashScreen.name){
        composable(SplashScreen.name){
            SplashScreen(navController = navHostController)
        }
        composable(HomeScreen.name){
            HomeScreen(navController = navHostController)
        }
        composable(SchedulerScreen.name){

        }
    }
}
