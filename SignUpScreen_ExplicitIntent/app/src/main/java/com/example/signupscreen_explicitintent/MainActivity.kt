package com.example.signupscreen_explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameEditText = findViewById<EditText>(R.id.name)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val ageEditText = findViewById<EditText>(R.id.age)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
        val readingCheckBox = findViewById<CheckBox>(R.id.readingCheckBox)
        val travelingCheckBox = findViewById<CheckBox>(R.id.travelingCheckBox)
        val sportsCheckBox = findViewById<CheckBox>(R.id.sportsCheckBox)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val age = ageEditText.text.toString()

            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.maleRadioButton -> "Male"
                R.id.femaleRadioButton -> "Female"
                else -> "Not specified"
            }

            val hobbies = mutableListOf<String>()
            if (readingCheckBox.isChecked) hobbies.add("Reading")
            if (travelingCheckBox.isChecked) hobbies.add("Traveling")
            if (sportsCheckBox.isChecked) hobbies.add("Sports")

            val hobbiesString = hobbies.joinToString(", ")

            val intent = Intent(this, DataActivity::class.java).apply {
                putExtra("name", name)
                putExtra("password", password)
                putExtra("age", age)
                putExtra("gender", gender)
                putExtra("hobbies", hobbiesString)
            }
            startActivity(intent)
        }
    }
}