package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class personalSettingActivity : AppCompatActivity() {
    private lateinit var clearButton: ImageButton
    private lateinit var logOut: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_setting_layout)

        clearButton = findViewById(R.id.clearButton_personalSetting)
        clearButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//            overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right)
        })

        logOut = findViewById(R.id.logOut)
        logOut.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, signInActivity::class.java)
            startActivity(intent)

        })
    }
}