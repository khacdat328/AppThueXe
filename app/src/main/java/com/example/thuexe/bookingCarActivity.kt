package com.example.thuexe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class bookingCarActivity:AppCompatActivity() {
    private lateinit var confirm_button: TextView
    private lateinit var confirm_layout: RelativeLayout
    private lateinit var back_imageBtn: Button
    private lateinit var startDate2: EditText
    private lateinit var endDate2: EditText
    private lateinit var number_of_day_rental: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking_car_layout)

        startDate2 = findViewById(R.id.StartDate2)
        endDate2 = findViewById(R.id.EndDate2)

        val intent = getIntent()
        val startDate = intent.getStringExtra("startDate")
        val endDate = intent.getStringExtra("endDate")

        startDate2.setText(startDate)
        endDate2.setText(endDate)

        number_of_day_rental = findViewById(R.id.number_of_day_rental)
        number_of_day_rental.setText((endDate2.text.toString().toInt()-startDate2.text.toString().toInt() + 1).toString() + " ngày")

        var total: TextView = findViewById(R.id.total)
        var totalPay: TextView = findViewById(R.id.totalPay)
        totalPay.setText(total.text)

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