package com.example.thuexe

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.help_layout.*
import java.util.jar.Manifest

class helpActivity : AppCompatActivity() {
    val phoneNumber = "0123456789"
    val mail = "trungph201@gmail.com"
    val REQUEST_PHONE_CALL = 1
    var Url_facebook = "https://www.facebook.com/phmdactrung.0308/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help_layout)

        callBtn.setOnClickListener{
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
            } else {
                startCall()
            }
        }

        sendEmailBtn.setOnClickListener{
            var recipient = mail.trim()
//            var subject = subjectEt.text.toString().trim()
//            var message = messageEt.text.toString().trim()
            
//            sendEmail(recipient, subject, message)
            sendMail(recipient)
        }

        facebook.setOnClickListener{
            var url= Intent(Intent.ACTION_VIEW)
            url.data=Uri.parse("https://www.facebook.com/phmdactrung.0308/")
            startActivity(url)
        }
        twitter.setOnClickListener{
            var url= Intent(Intent.ACTION_VIEW)
            url.data=Uri.parse("https://www.facebook.com/phmdactrung.0308/")
            startActivity(url)
        }
        instagram.setOnClickListener{
            var url= Intent(Intent.ACTION_VIEW)
            url.data=Uri.parse("https://www.instagram.com/hoc.sinh.ngoan/")
            startActivity(url)
        }
    }

    private fun sendMail(recipient: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "message/rfc822"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        } catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "message/rfc822"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        } catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + phoneNumber)
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_PHONE_CALL)
            startCall()
    }
}