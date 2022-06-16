package Adapter

import Model.Contract
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.thuexe.R

class adminContractAdapter(
    private val context: Activity,
    private val arrayList: ArrayList<Contract>
) : ArrayAdapter<Contract>(context, R.layout.admin_contract_adapter, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.admin_contract_adapter, null)

        val clientImage: ImageView = view.findViewById(R.id.userAdminContractImage)
        val userName: TextView = view.findViewById(R.id.clientAdminContractName)
        val userPhoneNumber : TextView = view.findViewById(R.id.clientAdminContractPhoneNumber)

        val carName: TextView = view.findViewById(R.id.carAdminContractName)
        val carPlate : TextView = view.findViewById(R.id.carAdminContractPlateNumber)

        userName.text = arrayList[position].clientName
        userPhoneNumber.text = arrayList[position].phoneNumber

        carName.text = arrayList[position].carName
        carPlate.text = arrayList[position].Bienso
            return view
    }
}