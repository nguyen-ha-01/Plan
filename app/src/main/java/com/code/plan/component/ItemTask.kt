package com.code.plan.component

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
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
import com.code.plan.ui.theme.statusTimeColor
import com.code.plan.ui.theme.taskTextColor
import java.util.*

@Preview(showBackground = true)
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
                        TimeText(task.start,task.end)
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
    Canvas(modifier = Modifier
        .size(sxWid, sxHei)
        .background(Color.Black)){

    }

}

internal fun DateK.formatTime() = " ${year}/${month}/${day} "
@Composable
fun TimeText(start: String, end: String) {
    var startT by remember {
        mutableStateOf(Trans.stringToDate(start).formatTime())
    }
    var endT by remember {
        mutableStateOf(Trans.stringToDate(end).formatTime())
    }

    Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
        Text(text = startT, fontStyle = FontStyle.Italic,color = taskTextColor, fontWeight = FontWeight.Normal)

        Text(endT, fontStyle = FontStyle.Italic,color = taskTextColor, fontWeight = FontWeight.Normal)

    }

}
