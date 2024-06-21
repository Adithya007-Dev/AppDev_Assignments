package com.example.browser_integration_implicit_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextUrl: EditText
    private lateinit var buttonOpenUrl: Button
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextUrl = findViewById(R.id.editTextUrl)
        buttonOpenUrl = findViewById(R.id.buttonOpenUrl)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSendMessage = findViewById(R.id.buttonSendMessage)


        buttonOpenUrl.setOnClickListener {
            openUrl(editTextUrl.text.toString())
        }

        buttonSendMessage.setOnClickListener {
            sendSms("1234567890", editTextMessage.text.toString())
        }
    }

    private fun openUrl(url: String)
    {
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }

    private fun sendSms(phoneNumber: String, message: String)
    {
        val intent = Intent(Intent.ACTION_SENDTO).apply{
            data = Uri.parse("smsto:$phoneNumber")
            putExtra("sms_body", message)
        }

            startActivity(intent)
    }
}
