package com.code.plan.component

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.code.datalayer.component.DateK
import com.code.datalayer.constant.taskDf
import com.code.datalayer.entities.Task

import com.code.domain.component.Trans
import com.code.plan.ui.theme.HighlighterHyssop
import com.code.plan.ui.theme.taskTextColor
import java.time.LocalDate
import java.util.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemTask(task: Task = taskDf){
    BoxWithConstraints() {
        val maxHeight = this.maxHeight
        val maxWid = this.maxWidth
        Log.i("size",maxHeight.value.toString()+"hei")
        Log.i("size",maxWid.value.toString()+"wid")
        Card(Modifier.widthIn(maxWid*0.5f,maxWid*0.8f)) {
            Row(Modifier
                .background(HighlighterHyssop)
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Column(horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .widthIn(maxWid * 0.3f, maxWid * 0.6f)) {
                    Row(Modifier
                        .wrapContentSize()
                        .padding(vertical = 8.dp)) {
                        TimeText(task.start.toString(),task.end.toString())
                    }
                    Text(text = task.title, color = taskTextColor)
                }
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                    TimeStBar(total = 10f, done = 2f, sxWid = 50.dp, sxHei = 50.dp)


                }
            }
        }
    }
}
@Composable
fun TimeStBar(total: Float, done:Float,sxWid: Dp,sxHei: Dp){
    var width     by rememberSaveable {
        mutableStateOf(0f)
    }
    var height    by rememberSaveable {
        mutableStateOf(0f)
    }
    val ani = rememberInfiniteTransition()
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    val offsetTran by ani.animateFloat(initialValue = 0f,
        targetValue = height,
        animationSpec = infiniteRepeatable(tween(2000),RepeatMode.Reverse))
    val waveTrans by ani.animateFloat(initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
        tween(1000),RepeatMode.Reverse))
    val path = Path().apply {
        moveTo(width/2f,0f)
        quadraticBezierTo(width*3f/4f,0f,width*3f/4f,height*.2f)
        lineTo(width.times(0.75f),height*0.8f)
        quadraticBezierTo(width*3f/4f,height,width*2f/4f,height)
        quadraticBezierTo(width*1f/4f,height,width*1f/4f,height*.8f)
        lineTo(width/4f,0.2f*height)
        quadraticBezierTo(width/4f,0f,width*0.5f,0f)
        close()
    }

    Canvas(modifier = Modifier
        .size(sxWid, sxHei)
        .background(Color.Black)){
        width = size.width
        height = size.height/2f

//        drawLine(Teal200, Offset(0f, canvasHeight), Offset(offsetTran, 0f), strokeWidth = 3f, StrokeCap.Round)
//        drawPoints(listOf(Offset(canvasWidth/2f,64f* cos(waveTrans)+canvasHeight/4f)), pointMode = PointMode.Points,
//            Color.White, strokeWidth = 16f,cap = StrokeCap.Round)
        drawPath(path, Brush.linearGradient(instaColors))
    }

}

internal fun LocalDate.formatTime() = " ${year}/${month}/${dayOfMonth} "
@Composable
fun TimeText(start: String, end: String) {
    var startT by remember {
        mutableStateOf(LocalDate.parse(start).formatTime())
    }
    var endT by remember {
        mutableStateOf(LocalDate.parse(end).formatTime())
    }

    Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
        Text(text = startT, fontStyle = FontStyle.Italic,color = taskTextColor, fontWeight = FontWeight.Normal)

        Text(endT, fontStyle = FontStyle.Italic,color = taskTextColor, fontWeight = FontWeight.Normal)

    }

}
