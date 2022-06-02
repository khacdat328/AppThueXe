package com.example.thuexe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class carsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cars_layout)

        var cars_layout: LinearLayout = findViewById(R.id.cars_layout_header)
        val header: View = layoutInflater.inflate(R.layout.header_layout, null)
        cars_layout.addView(header)

    }
}