package com.example.classscheduleorganizer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdapter(val scheduleItems: List<ScheduleItem>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subjectImage: ImageView = view.findViewById(R.id.subjectImage)
        val subjectName: TextView = view.findViewById(R.id.subjectName)
        val classTime: TextView = view.findViewById(R.id.classTime)
        val attendedCheckbox: CheckBox = view.findViewById(R.id.attendedCheckbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = scheduleItems[position]
        holder.subjectImage.setImageResource(item.imageResId)
        holder.subjectName.text = item.subject
        holder.classTime.text = item.time
        holder.attendedCheckbox.isChecked = item.isAttended

        holder.attendedCheckbox.setOnCheckedChangeListener { _, isChecked ->
            item.isAttended = isChecked
        }
    }

    override fun getItemCount() = scheduleItems.size
}

data class ScheduleItem (
    val id: Int,
    val subject: String,
    val time: String,
    val imageResId: Int,
    var isAttended: Boolean = false
)


