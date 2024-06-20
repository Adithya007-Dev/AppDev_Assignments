package com.example.support_language

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        val editTextUsername: EditText = findViewById(R.id.editTextUsername)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra("username", username)
            }
            startActivity(intent)
        }
    }
}