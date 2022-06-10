package com.code.plan.activities.act1

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PermissionInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.code.plan.navigation.NavHost
import com.code.plan.activities.act1.theme.BackgroundColor
import com.code.plan.activities.act1.theme.PlanTheme
import com.code.plan.activities.act2.Activity2
import com.code.plan.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.security.Permission
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var  mainviewmodel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listPermission = listOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.QUERY_ALL_PACKAGES)
        setContent {
            PlanTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor) {
                    Column() {
                        requestPermission(listPermission)
                        NavHost()

//                        Intent(this@MainActivity,Activity2::class.java).let {
//                            this@MainActivity.startActivity(it)
//                        }

                    }
                }
            }
        }
    }

    fun requestPermission(list: List<String>){
        var notAgreeYet = mutableListOf<String>()
        list.forEach {
            if(this.checkSelfPermission(it)==PackageManager.PERMISSION_DENIED){
                notAgreeYet.add(it)
            }
        }
        if (notAgreeYet.isNotEmpty())
        this.requestPermissions(notAgreeYet.toTypedArray(),10)
    }
}