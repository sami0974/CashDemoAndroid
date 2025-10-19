package com.cashdemo.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cashdemo.app.data.dao.UserDao
import com.cashdemo.app.data.dao.TransactionDao
import com.cashdemo.app.data.entity.User
import com.cashdemo.app.data.entity.Transaction

@Database(entities = [User::class, Transaction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun transactionDao(): TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cashdemo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

