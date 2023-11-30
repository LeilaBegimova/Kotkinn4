package com.example.kotkinn4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    private lateinit var btnWhatsApp : MaterialCardView
    private lateinit var phoneEditText: EditText
    private lateinit var ivImage: ImageView

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        ivImage.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWhatsApp = this.findViewById(R.id.knopka)
        phoneEditText = this. findViewById(R.id.texs_two)
        ivImage = this.findViewById(R.id.viev)
        goToWhatsApp()
        chooseImegeFromGallery()
    }
    private fun goToWhatsApp() {
        btnWhatsApp.setOnClickListener{
            val whatsAppIntentSearchUrl = "https://wa.me/"
            val number = "+996${phoneEditText.text.trim().toString()}"
            val whatsAppIntent = Intent (Intent.ACTION_VIEW, Uri.parse(whatsAppIntentSearchUrl + number))
            startActivity(whatsAppIntent)
        }
    }
    private fun chooseImegeFromGallery() {
       ivImage.setOnClickListener {
//         Intent(Intent.ACTION_GET_CONTENT).apply {
//             type = "image/*"
//             action = Intent.ACTION_GET_CONTENT
             getContent.launch("image/*")
//         }
       }
    }

}
