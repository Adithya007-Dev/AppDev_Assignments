package com.example.support_language

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra("username")
        val welcomeMessage = getString(R.string.welcome_message, username)

        val textViewWelcome: TextView = findViewById(R.id.textViewWelcome)
        textViewWelcome.text = welcomeMessage
    }
}
