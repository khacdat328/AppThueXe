package com.example.thuexe

import Adapter.CarManagementAdapter
import Model.CarManagement
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class carmanagement : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var carList: ArrayList<CarManagement>
    private lateinit var carAdapter: CarManagementAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quan_ly_xe)
        recyclerView = findViewById(R.id.car_list)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        carList = ArrayList()
        carList.add(CarManagement("Ducaty",10000,"Chu Se"))
        carList.add(CarManagement("lamborghini",10000,"Tan Binh"))
        carList.add(CarManagement("Exciter",10000,"Tan Binh"))
        carAdapter = CarManagementAdapter(carList)
        recyclerView.adapter= carAdapter

    }
}