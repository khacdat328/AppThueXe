package com.example.thuexe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Dashboard : AppCompatActivity() {
    private lateinit var backwardBtn: TextView
    private lateinit var addItemTbn: Button
    private lateinit var clientManager: Button
    private lateinit var contractsManager: Button
    private lateinit var itemManager: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        backwardBtn = findViewById(R.id.adminBackBtn)
        addItemTbn = findViewById(R.id.ThemSP)
        itemManager = findViewById(R.id.QuanLySP)
        contractsManager = findViewById(R.id.QuanLyHD)
        clientManager = findViewById(R.id.QuanLyKH)

        backwardBtn.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        addItemTbn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ThemSanPham::class.java)
            startActivity( intent )
        }  )

        itemManager.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, QuanLySanPham::class.java)
            startActivity( intent )
        }  )

        contractsManager.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, QuanLyHopDong::class.java)
            startActivity( intent )
        }  )

        clientManager.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, QuanLyKhachHang::class.java)
            startActivity( intent )
        }  )
    }
}