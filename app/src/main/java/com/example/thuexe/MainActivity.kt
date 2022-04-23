package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var searchText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchText = findViewById(R.id.searchText)

        var temp = arrayOf<String>("nextPage", "aaa", "new")

        searchText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                val text: String = searchText.text.toString()
                for(i in temp.indices){
                    if( text?.equals(temp)){
                        val intent = Intent(this@MainActivity, carsActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
    }
}