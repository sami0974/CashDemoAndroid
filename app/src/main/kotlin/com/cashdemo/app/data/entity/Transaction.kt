package com.cashdemo.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String,
    val recipientName: String,
    val amount: Double,
    val type: String, // "sent" or "received"
    val timestamp: Long = System.currentTimeMillis(),
    val description: String = ""
)

