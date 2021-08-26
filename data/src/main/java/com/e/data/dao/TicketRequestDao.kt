package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.data.entity.TicketRequest
import com.e.data.entity.local.Ticket

@Dao
interface TicketRequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTickets(ticketRequest: Ticket)

    @Query("DELETE FROM Ticket")
    suspend fun deleteTickets()

    @Query("SELECT * FROM Ticket")
    suspend fun getTicketsList(): MutableList<Ticket>

}