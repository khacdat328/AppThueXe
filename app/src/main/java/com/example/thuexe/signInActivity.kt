package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class signInActivity : AppCompatActivity() {
    private lateinit var nameAccount: EditText
    private lateinit var password: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_layout)

        var _nameAccount: String = "account01"
        var _password: String = "pass123"

        nameAccount = findViewById(R.id.nameAccount)
        password = findViewById(R.id.password)
        signInButton = findViewById(R.id.signInButton)
        signInButton.setOnClickListener(View.OnClickListener {
            if(nameAccount.text.toString().equals(_nameAccount)
                && password.text.toString().equals(_password)){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        })

        signUpText = findViewById(R.id.signUpText)
        signUpText.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, signUpActivity::class.java)
            startActivity(intent)
        })
    }
}