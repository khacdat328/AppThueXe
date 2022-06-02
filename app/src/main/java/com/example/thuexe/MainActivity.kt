package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var imageBrand: ImageView

    private lateinit var car: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var main_layout: LinearLayout = findViewById(R.id.main_layout_header)
        val header: View = layoutInflater.inflate(R.layout.header_layout, null)
        main_layout.addView(header)

        imageBrand = findViewById(R.id.imageBrandAudi)
        imageBrand.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, carsActivity::class.java)
            startActivity(intent)
        })

        car = findViewById(R.id.car_1)
        car.setOnClickListener({
            val intent = Intent(this, carDetailActivity::class.java)
            startActivity(intent)
        })
    }
}