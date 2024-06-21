package com.example.signupscreen_explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name= intent.extras?.getString("name")
        val password= intent.extras?.getString("password")
        val age= intent.extras?.getString("age")
        val gender= intent.extras?.getString("gender")
        val hobbies= intent.extras?.getString("hobbies")

        val nametv=findViewById<TextView>(R.id.textView5)
        nametv.text = "Name: $name"

        val passwordtv=findViewById<TextView>(R.id.textView6)
        passwordtv.text = "Password: $password"

        val agetv=findViewById<TextView>(R.id.textView7)
        agetv.text = "Age: $age"

        val gendertv=findViewById<TextView>(R.id.textView8)
        gendertv.text = "Gender: $gender"
        val hobbiestv=findViewById<TextView>(R.id.textView9)
        hobbiestv.text = "Hobbies: $hobbies"
    }
}