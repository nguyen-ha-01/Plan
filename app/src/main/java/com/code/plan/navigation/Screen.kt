package com.code.plan.navigation

import java.lang.reflect.Constructor

data class Screen(val name: String , val route: String)
val  SplashScreen : Screen = Screen("SplashScreen","SplashScreen")
//    fun additionalData(names: String):String
val HomeScreen          : Screen = Screen("HomeScreen","HomeScreen")
val SchedulerScreen: Screen = Screen("SchedulerScreen","SchedulerScreen")
val ConstructorPlanScreen : Screen = Screen("ConstructorPlanScreen","ConstructorPlanScreen")
