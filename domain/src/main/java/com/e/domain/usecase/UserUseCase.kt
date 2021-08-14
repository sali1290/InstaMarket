package com.e.domain.usecase

interface UserUseCase<R> {

    suspend fun execute(): MutableList<R>

}