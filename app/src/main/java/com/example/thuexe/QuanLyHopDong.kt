package com.example.thuexe

import Adapter.adminContractAdapter
import Model.Contract
import Model.hopdong
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thuexe.databinding.ActivityQuanLyHopDongBinding
import com.example.thuexe.databinding.ActivityQuanLyKhachHangBinding
import kotlinx.android.synthetic.main.quan_ly_hop_dong_layout.*

class QuanLyHopDong : AppCompatActivity() {

    private lateinit var binding1: ActivityQuanLyHopDongBinding
    private lateinit var contractArrayList: ArrayList<Contract>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityQuanLyHopDongBinding.inflate(layoutInflater)
        setContentView(R.layout.quan_ly_hop_dong_layout)

        val clientName =
            arrayOf("Pham Dac Trung", "Huynh Thanh Sang", "Nguyen Phu Cuong", "Chau Khac Dat","Chau Khac Dat")

        val phoneNumber = arrayOf("0123456789", "01346789852", "01346789852", "01346789852","01346789852")
        val carName = arrayOf("Lamborghini", "Huayra", "Air Blade", "Mercedes","Mercedes")
        val carPlate = arrayOf("81P1-11590", "81P1-11590", "81P1-11590", "81P1-11590","81P1-11590")

        contractArrayList = ArrayList()
        for(i in clientName.indices){
            val contract = Contract(clientName[i],phoneNumber[i],carName[i],carPlate[i])
            contractArrayList.add(contract)
        }

        adminContractListview.adapter = adminContractAdapter(this, contractArrayList)
    }
}