package com.code.plan.screens


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.code.plan.activities.act1.theme.SplashBrush
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController,modifier: Modifier = Modifier){
    val ctx = LocalContext.current
    Surface(modifier
        .fillMaxSize()) {
        Column(verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally) {
           SplashAnimate()
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashAnimate(modifier: Modifier = Modifier,brush: Brush = SplashBrush,_size: DpSize = DpSize(150.dp,150.dp)){

        var run by remember {
            mutableStateOf(false)
        }
        var run_ by remember {
            mutableStateOf(true)
        }
        LaunchedEffect(key1 = true){
            delay(200)
            run = true
            delay(600)
            run_ = false
        }

        val w = _size.width.value
        val stroke_ = animateFloatAsState(targetValue =   if (run)w*0.12f else w*0.5f, tween(600))
        val alpha_ =  animateFloatAsState(targetValue =   if (run_)1f else 0f, tween(500))
        val bgColor = MaterialTheme.colors.background
        Canvas(modifier = modifier.graphicsLayer {
            this.alpha = alpha_.value
        }
            .size(_size)
            .background(bgColor)){
            val width  = size.width
            val h = size.height
            val p1_ = Offset(stroke_.value,stroke_.value)
            val p1__ = Offset(stroke_.value *2f,stroke_.value *2f)
            val size_  = Size(width-2f*p1_.x,width-2f*p1_.x)
            val size__  = Size(width-4f*p1_.x,width-4f*p1_.x)
            drawRoundRect(brush,p1_,size_, cornerRadius = CornerRadius(18f,18f))
            drawRoundRect(bgColor,p1__,size__, cornerRadius = CornerRadius(18f,18f))
            val startLine : Offset = Offset(width/2,h/2)
            val endLine : Offset = Offset(width-2*p1_.x,p1_.y*2)
            val endLine_ : Offset = Offset(2*p1_.x,h-p1_.y*2)
            drawLine(brush,startLine,endLine, strokeWidth = p1_.x, cap = StrokeCap.Round)
            drawLine(brush,startLine,endLine_, strokeWidth = p1_.x, cap = StrokeCap.Round)
        }

}
