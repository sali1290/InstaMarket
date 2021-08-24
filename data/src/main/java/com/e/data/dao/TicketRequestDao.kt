package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.data.entity.TicketRequest

@Dao
interface TicketRequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTickets(ticketRequest: TicketRequest)

    @Query("DELETE FROM TicketRequest")
    suspend fun deleteTickets()

    @Query("SELECT * FROM TicketRequest")
    suspend fun getTicketsList(): MutableList<TicketRequest>

}