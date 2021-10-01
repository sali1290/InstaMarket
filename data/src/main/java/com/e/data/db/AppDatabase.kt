package com.e.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.e.data.dao.*
import com.e.data.entity.*
import com.e.data.entity.local.Order
import com.e.data.entity.local.Ticket
import com.e.data.entity.local.User
import com.e.data.entity.remote.Transaction

@Database(
    entities = [Ticket::class, Order::class, Token::class,
        TicketRequest::class, LuckRequest::class, User::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    UserTypeConverter::class,
    ErrorTypeConverter::class,
    TicketTypeConverter::class,
    OrderTypeConverter::class,
    LuckUserTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    abstract fun luckRequestDao(): LuckRequestDao

    abstract fun ticketRequestDao(): TicketRequestDao

    abstract fun tokenDao(): TokenDao

    abstract fun userDao(): UserDao

}