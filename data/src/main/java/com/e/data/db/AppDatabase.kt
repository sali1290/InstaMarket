package com.e.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.e.data.dao.*
import com.e.data.entity.*

@Database(
    entities = [User::class, Transaction::class, SocialMedia::class, Product::class, Category::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun transactionDao(): TransactionDao

    abstract fun socialMediaDao(): SocialMediaDao

    abstract fun categoryDao(): CategoryDao

    abstract fun productDao(): ProductDao


}