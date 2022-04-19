package com.example.thuexe

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.WindowManager




class AndroidDeviceHelper {
    fun getScreenSize(context: Context): Point? {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size
    }

    fun getScreenWidth(context: Context?): Int {
        return getScreenSize().x

    }

    fun getScreenHeight(context: Context?): Int {
        return getScreenSize().y
    }
}