package com.example.thuexe

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.WindowManager




class AndroidDeviceHelper {
    fun getWithScreen(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }

    fun getHeightScreen(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.y
    }
}