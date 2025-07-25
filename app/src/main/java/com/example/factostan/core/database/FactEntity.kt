package com.example.factostan.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fact")
data class FactEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val text: String,
    val source: String? = null,
)

