package Adapter

import Model.CarManagement
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.thuexe.R

class CarManagementAdapter(private val carList: ArrayList<CarManagement> )
    : RecyclerView.Adapter<CarManagementAdapter.CarViewHolder>()  {
    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.carManagement_Img)
        val carPrice : TextView = itemView.findViewById(R.id.carManagement_price)
        val carName : TextView = itemView.findViewById(R.id.carManagement_Name)
        val carAddress : TextView = itemView.findViewById(R.id.carManagement_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_cardview_layout, parent  , false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.carPrice.text = car.carPrice.toString()
        holder.carName.text = car.carName
        holder.carAddress.text= car.Address

    }

    override fun getItemCount(): Int {
        return carList.size
    }
}