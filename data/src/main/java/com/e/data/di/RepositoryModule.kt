package com.e.data.di

import com.e.data.repository.*
import com.e.data.repository.appInfoDataSource.AppInfoRemoteDataSource
import com.e.data.repository.appInfoDataSource.AppInfoRemoteDataSourceImpl
import com.e.data.repository.enterAppDataSource.remote.EnterAppRemoteDataSource
import com.e.data.repository.enterAppDataSource.remote.EnterAppRemoteDataSourceImpl
import com.e.data.repository.luckWheelDataSource.remote.LuckWheelRemoteDataSource
import com.e.data.repository.luckWheelDataSource.remote.LuckWheelRemoteDataSourceImpl
import com.e.data.repository.orderDataSource.remote.OrderRemoteDataSource
import com.e.data.repository.orderDataSource.remote.OrderRemoteDataSourceImpl
import com.e.data.repository.ticketDataSource.remote.TicketRemoteDataSource
import com.e.data.repository.ticketDataSource.remote.TicketRemoteDataSourceImpl
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSource
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSourceImpl
import com.e.data.repository.userDataSource.remote.UserRemoteDataSource
import com.e.data.repository.userDataSource.remote.UserRemoteDataSourceImpl
import com.e.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    //for repo
    @Binds
    abstract fun bindAppInfoRepo(
        appInfoRepoImpl: AppInfoRepoImpl
    ): AppInfoRepo

    @Binds
    abstract fun bindEnterAppRepo(
        enterAppRepoImpl: EnterAppRepoImpl
    ): EnterAppRepo

    @Binds
    abstract fun bindLuckWheelRepo(
        luckWheelRepoImpl: LuckWheelRepoImpl
    ): LuckWheelRepo

    @Binds
    abstract fun bindOrderRepo(
        orderRepoImpl: OrderRepoImpl
    ): OrderRepo

    @Binds
    abstract fun bindTicketRepo(
        ticketRepoImpl: TicketRepoImpl
    ): TicketRepo

    @Binds
    abstract fun bindTransactionRepo(
        transactionRepoImpl: TransactionRepoImpl
    ): TransactionRepo

    @Binds
    abstract fun bindUserRepo(
        userRepoImpl: UserRepoImpl
    ): UserRepo


    //for repo impl
    @Binds
    abstract fun bindEnterAppRemoteDataSource(
        enterAppRemoteDataSourceImpl: EnterAppRemoteDataSourceImpl
    ): EnterAppRemoteDataSource


    @Binds
    abstract fun bindAppInfoLocalDataSource(
        appInfoRemoteDataSourceImpl: AppInfoRemoteDataSourceImpl
    ): AppInfoRemoteDataSource

    @Binds
    abstract fun bindLuckWheelRemoteDataSource(
        luckWheelRemoteDataSourceImpl: LuckWheelRemoteDataSourceImpl
    ): LuckWheelRemoteDataSource

    @Binds
    abstract fun bindOrderRemoteDataSource(
        orderRemoteDataSourceImpl: OrderRemoteDataSourceImpl
    ): OrderRemoteDataSource


    @Binds
    abstract fun bindTicketRemoteDataSource(
        ticketRemoteDataSourceImpl: TicketRemoteDataSourceImpl
    ): TicketRemoteDataSource


    @Binds
    abstract fun bindTransactionRemoteDataSource(
        transactionRemoteDataSourceImpl: TransactionRemoteDataSourceImpl
    ): TransactionRemoteDataSource

    @Binds
    abstract fun bindUserRemoteDataSource(
        userRemoteDataSourceImpl: UserRemoteDataSourceImpl
    ): UserRemoteDataSource



}