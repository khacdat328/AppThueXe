package com.example.thuexe

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.extensions.Extensions.toast
import com.example.thuexe.databinding.ActivityThemSanPhamBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_them_san_pham.*
import java.lang.Deprecated
import java.text.SimpleDateFormat
import java.util.*

class ThemSanPham : AppCompatActivity() {
    private lateinit var binding: ActivityThemSanPhamBinding
    private lateinit var database: DatabaseReference
    private lateinit var ImageUri : Uri
    private lateinit var img_key : String
    private lateinit var backwardBtn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemSanPhamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.adminBackBtn.setOnClickListener {
            this.finish()
        }

        binding.selectImg.setOnClickListener {
            selectImg()
        }
        binding.input.setOnClickListener {
            uploadImg()
            val Ten_xe = binding.TenXe.text.toString()
            val Loai_xe = binding.LoaiXe.text.toString()
            val Bien_so = binding.BienSo.text.toString()
            val Gia = binding.Gia.text.toString().toFloat()
            val Loai_Nhien_lieu = binding.LoaiNhienLieu.text.toString()
            val Phan_khuc = binding.PhanKhuc.text.toString()
            val Ghe = binding.Ghe.text.toString().toInt()
            val Cua = binding.Cua.text.toString().toInt()
            val Mo_ta = binding.MoTa.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Car")
            val Car = Cars(Ten_xe, Loai_xe, Bien_so, Gia, Loai_Nhien_lieu, Phan_khuc, Ghe, Cua, Mo_ta,"Ho Chi Minh",img_key )
            database.push().key?.let {
                database.child(it).setValue(Car).addOnSuccessListener {

                    binding.TenXe.text.clear()
                    binding.LoaiXe.text.clear()
                    binding.BienSo.text.clear()
                    binding.Gia.text.clear()
                    binding.LoaiNhienLieu.text.clear()
                    binding.PhanKhuc.text.clear()
                    binding.Ghe.text.clear()
                    binding.Cua.text.clear()
                    binding.MoTa.text.clear()


                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT)

                }.addOnFailureListener {

                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT)


                }


            }

        }
    }


    private fun uploadImg() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading ...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val filename = formatter.format(now)
        img_key = "Images/" + filename.toString() + ".png"

        val storageReference = FirebaseStorage.getInstance().getReference("Images/$filename.png")
        storageReference.putFile(ImageUri)
            .addOnSuccessListener {
                binding.fbImg.setImageURI(null)
                Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                if(progressDialog.isShowing) progressDialog.dismiss()

            }.addOnFailureListener {

                if(progressDialog.isShowing) progressDialog.dismiss()
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

    }

    private fun selectImg() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 100 && resultCode == RESULT_OK){
            ImageUri = data?.data!!
            binding.fbImg.setImageURI(ImageUri)
            fb_img1.visibility =View.INVISIBLE
        }
    }
}