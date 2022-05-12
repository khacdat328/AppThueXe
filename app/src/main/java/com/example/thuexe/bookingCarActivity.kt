package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class bookingCarActivity:AppCompatActivity() {
    private lateinit var confirm_button: TextView
    private lateinit var confirm_layout: RelativeLayout
    private lateinit var back_imageBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking_car_layout)

        back_imageBtn = findViewById(R.id.back_Button)
        back_imageBtn.setOnClickListener {
            val intent = Intent(this, carDetailActivity::class.java)
            startActivity(intent)
        }

        confirm_button = findViewById(R.id.confirm_text_button)
        confirm_layout = findViewById(R.id.confirm_layout)
        confirm_button.setOnClickListener {
            Toast.makeText(confirm_layout.context,"Thành công!", Toast.LENGTH_SHORT).show()
        }
    }
}