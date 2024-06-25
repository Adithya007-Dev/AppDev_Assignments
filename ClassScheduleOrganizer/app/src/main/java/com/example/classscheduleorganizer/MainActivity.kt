package com.example.classscheduleorganizer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView= findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val scheduleItems = listOf(
            ScheduleItem(1, "Math", "09:00 AM", R.drawable.ic_math),
            ScheduleItem(2, "History", "10:30 AM", R.drawable.ic_history),
            ScheduleItem(3, "Science", "01:00 PM", R.drawable.ic_science),
            ScheduleItem(4, "English", "02:30 PM", R.drawable.ic_english)
        )
        val adapter = ScheduleAdapter(scheduleItems)
        recyclerView.adapter = adapter
    }
}