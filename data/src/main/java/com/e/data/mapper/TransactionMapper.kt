package com.e.data.mapper

import com.e.data.entity.remote.Transaction
import com.e.domain.models.TransactionModel
import javax.inject.Inject

class TransactionMapper @Inject constructor(){
    fun toMapper(agents: Transaction): TransactionModel {
        return TransactionModel(
            agents.id ?: 0,
            agents.ids ?: "",
            agents.uid ?: "",
            agents.type ?: "",
            agents.transactionId ?: "",
            agents.amount ?: "",
            agents.status ?: "",
            agents.created ?: "",
            agents.log ?: "",
            agents.systemi ?: "",
            agents.payerEmail ?: "",
            agents.txnFee ?: "",
            agents.note ?: ""
        )
    }
}