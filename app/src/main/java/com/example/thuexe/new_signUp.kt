package com.example.thuexe

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*


class new_signUp : AppCompatActivity() {
    private lateinit var DoB: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_sign_up)

    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.male ->
                    if (checked) {
                        // Pirates are the best
                    }
                R.id.female ->
                    if (checked) {
                        // Ninjas rule
                    }
                R.id.other ->
                    if (checked) {
                        // Ninjas rule
                    }
            }
        }
    }

}