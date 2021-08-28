package com.e.data.di

import com.e.data.repository.*
import com.e.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

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


}