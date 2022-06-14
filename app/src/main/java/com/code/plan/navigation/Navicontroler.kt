package com.code.plan.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.code.plan.activities.act2.Activity2
import com.code.plan.screens.HomeScreen
import com.code.plan.screens.SchedulerScreen
import com.code.plan.screens.SplashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import java.util.concurrent.CompletionService



@Composable
fun NavHost(navHostController: NavHostController, modifier : Modifier = Modifier){
    NavHost(navController = navHostController, startDestination = HomeScreen.name, modifier = modifier){
        login(navHostController)
        main(navHostController)
    }
}
fun NavGraphBuilder.main(navHostController: NavHostController){

    composable(HomeScreen.name){
        HomeScreen(navController = navHostController)
    }
    composable(SchedulerScreen.name){
        SchedulerScreen(navController = navHostController)
    }
}
fun NavGraphBuilder.login(navHostController: NavHostController){
    composable(SplashScreen.name,){
        SplashScreen(navController = navHostController)

    }
    //we can add login screen after
    //may be
}