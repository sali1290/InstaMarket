package com.e.data.di

import android.content.Context
import androidx.room.Room
import com.e.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "AppDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun provideOrderDao(db: AppDatabase) = db.orderDao()

    @Singleton
    @Provides
    fun provideTicketRequestDao(db: AppDatabase) = db.ticketRequestDao()

    @Singleton
    @Provides
    fun provideTokenDao(db: AppDatabase) = db.tokenDao()

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()


}