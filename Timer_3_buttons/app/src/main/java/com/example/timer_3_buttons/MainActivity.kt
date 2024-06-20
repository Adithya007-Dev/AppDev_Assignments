package com.example.timer_3_buttons

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val milkButton = findViewById<Button>(R.id.milk_button)
        val motorButton = findViewById<Button>(R.id.motor_button)
        val toasterButton = findViewById<Button>(R.id.toaster_button)

        milkButton.setOnClickListener { setTimer("Milk", 1) }
        motorButton.setOnClickListener { setTimer("Motor", 5) }
        toasterButton.setOnClickListener { setTimer("Toaster", 2) }
    }

    private fun setTimer(label: String, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, label)
            putExtra(AlarmClock.EXTRA_LENGTH, minutes * 60)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
            setPackage("com.google.android.deskclock")
        }

        try {
            startActivity(intent)
            Toast.makeText(this, "$label timer set for $minutes minutes", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Couldn't set timer: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}