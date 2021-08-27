package com.e.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.e.data.dao.*
import com.e.data.entity.*
import com.e.data.entity.local.Order
import com.e.data.entity.local.Ticket
import com.e.data.entity.remote.Transaction

@Database(
    entities = [Ticket::class, Order::class, Token::class,
        Transaction::class, TicketRequest::class,
        OrderRequest::class, LuckRequest::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    abstract fun luckRequestDao(): LuckRequestDao

    abstract fun ticketRequestDao(): TicketRequestDao

    abstract fun tokenDao(): TokenDao

}