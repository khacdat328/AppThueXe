package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class personalInfomationActivity: AppCompatActivity() {
    private lateinit var clearButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_infomation_layout)

        clearButton = findViewById(R.id.clearButton_personalSetting)
        clearButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, personalSettingActivity::class.java)
            startActivity(intent)
//            overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right)
        })
    }
}