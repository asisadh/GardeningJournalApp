package com.aashish.gardeningjournalapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val type: String,
    val wateringFrequency: Int,
    val plantDate: String,
)