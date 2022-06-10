package com.code.plan.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.code.plan.activities.act2.Activity2
import com.code.plan.screens.HomeScreen
import com.code.plan.screens.SchedulerScreen
import com.code.plan.screens.SplashScreen
import java.util.concurrent.CompletionService


@Composable
fun NavHost(navHostController: NavHostController = rememberNavController(), modifier : Modifier = Modifier){
    NavHost(navController = navHostController, startDestination = SplashScreen.name, modifier = modifier){
        composable(SplashScreen.name){
            SplashScreen(navController = navHostController)
        }
        composable(HomeScreen.name){
            HomeScreen(navController = navHostController)
        }
        composable(SchedulerScreen.name){
            SchedulerScreen(navController = navHostController)
        }
        activity(activity2.name){
            this.activityClass = Activity2::class
            this.build()
        }
    }
}
fun NavGraphBuilder.main(navHostController: NavHostController){

}