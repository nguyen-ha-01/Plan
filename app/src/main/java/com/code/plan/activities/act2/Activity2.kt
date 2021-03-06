package com.code.plan.activities.act2

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Contacts
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings.Global.getString
import android.provider.UserDictionary
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceAround
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.room.util.CursorUtil.getColumnIndex
import com.code.datalayer.provider.QueryPhoneNumber
import com.code.plan.activities.act1.MainActivity
import com.code.plan.activities.act2.theme.PlanTheme
import com.code.plan.activities.act2.theme.orange
import com.code.plan.screens.SplashAnimate
import kotlinx.coroutines.delay


class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        this.setContent {
            Column(Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally, verticalArrangement = SpaceAround) {
                SplashAnimate()
            }
                LocalLifecycleOwner.current.lifecycleScope.launchWhenStarted{
                    delay(1200)
                    Intent(this@Activity2,MainActivity::class.java).let {
                        this@Activity2.startActivity(it)
                    }
                    finish()
                }
        }
    }
}


@Composable
fun ExitDialog(unit: () -> Unit,show : MutableState<Boolean>){
    var showable by remember {
        mutableStateOf(show)
    }
    AnimatedVisibility(visible = showable.value) {
        Dialog(onDismissRequest = { showable.value = !showable.value }) {
            Card (Modifier.padding(18.dp).background(Color.White)){
                val brush = Brush.linearGradient(listOf(Color.Yellow,orange,Color.Red))
                Column() {

                    Text(text = "Do you want to exit?")
                    Row(horizontalArrangement = Arrangement.SpaceAround) {

                        Button(onClick = {unit()},
                            colors =ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                            border = BorderStroke(2.dp,brush),
                            shape = RoundedCornerShape(50.dp))
                        {
                            Text("yes")
                        }
                    }
                }
            }
        }
    }



}
@Composable
fun HandleBackPressed(unit :()-> Unit){
    val ctx:Context = LocalContext.current
    var showable = remember {
        mutableStateOf(false)
    }
    ExitDialog(unit = { unit() }, show = showable)

    BackHandler() {
       showable.value = true
        Log.i("back","clicked"+showable.toString())
    }
    Log.i("back","show_"+showable.toString())

}
