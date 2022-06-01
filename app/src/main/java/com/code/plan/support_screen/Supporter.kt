package com.code.plan.support_screen

import androidx.compose.ui.unit.Dp
import java.util.*

object SupporterScreenSize {
    enum class ScreenStatus{
        Horizontal//nam ngang
        ,Vertical
    }
    var screenWidthFloat:Float = 0f
    var screenHeightFloat: Float = 0f
    var status : ScreenStatus = ScreenStatus.Vertical
    fun setSize(w: Float,h: Float){
        if (screenHeightFloat !=0f && screenWidthFloat!= 0f ){
            return
        }
        screenWidthFloat = w
        screenHeightFloat = h
    }
    fun checkStatus(){
        if(screenWidthFloat < screenHeightFloat) status = ScreenStatus.Vertical
        else status = ScreenStatus.Horizontal
    }
}