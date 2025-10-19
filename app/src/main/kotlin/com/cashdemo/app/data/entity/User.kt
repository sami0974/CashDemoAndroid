package com.cashdemo.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String,
    val username: String,
    val email: String,
    val password: String,
    val balance: Double = 1000.0,
    val createdAt: Long = System.currentTimeMillis()
)

