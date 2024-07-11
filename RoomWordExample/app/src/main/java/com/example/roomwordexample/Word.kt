package com.example.roomwordexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val word:String
)