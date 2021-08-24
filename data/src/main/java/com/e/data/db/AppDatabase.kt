package com.e.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.e.data.dao.*
import com.e.data.entity.local.Order
import com.e.data.entity.local.User

@Database(
    entities = [User::class,  Order::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): OrderDao


}