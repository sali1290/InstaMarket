package com.e.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.e.data.dao.UserDao
import com.e.data.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}