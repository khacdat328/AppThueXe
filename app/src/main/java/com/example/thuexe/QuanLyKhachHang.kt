package com.example.thuexe

import Adapter.clientAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thuexe.databinding.ActivityQuanLyKhachHangBinding

class QuanLyKhachHang : AppCompatActivity() {
    private lateinit var binding: ActivityQuanLyKhachHangBinding
    private lateinit var clientlist: ArrayList<Client>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuanLyKhachHangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clientName = arrayOf("Chau Khac Dat","Pham Dac Trung","Huynh Thanh Sang")
        val clientPhone = arrayOf("0123456789","0135792468","9876543210")

        clientlist = ArrayList()

        for (i in clientName.indices){
            val client = Client(clientName[i], clientPhone[i])
            clientlist.add(client)
        }
        binding.clientListView.isClickable=true
        binding.clientListView.adapter = clientAdapter(this,clientlist)
    }
}