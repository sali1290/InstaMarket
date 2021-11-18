package com.e.data.mapper

import com.e.data.entity.User
import com.e.domain.models.UserModel
import javax.inject.Inject

class UserMapper @Inject constructor(){
    fun toMapper(user: User): UserModel {
        return UserModel(
            user.id ?: 0,
            user.ids ?: "",
            user.role ?: "",
            user.loginType ?: "",
            user.firstName ?: "",
            user.lastName ?: "",
            user.email ?: "",
            user.userName ?: "",
            user.phone ?: "",
            user.verifyPhone ?: "",
            user.timeZone ?: "",
            user.moreInformation ?: "",
            user.settings ?: "",
            user.desc ?: "",
            user.balance ?: "",
            user.customRate ?: "",
            user.apiKey ?: "",
            user.spent ?: "",
            user.activationKey ?: "",
            user.resetKey ?: "",
            user.historyIp ?: "",
            user.status ?: "",
            user.changed ?: "",
            user.created ?: "",
            user.ref ?: "",
            user.profitRate ?: "",
            user.alfa ?: "",
            user.minharvest ?: "",
            user.cardNumber ?: "",
            user.shNumber ?: "",
            user.accountName ?: "",
            user.bankName ?: "",
            user.verifyBank ?: "",
            user.verifyMore ?: "",
            user.birthday ?: "",
            user.education ?: "",
            user.marry ?: "",
            user.sex ?: "",
            user.avatar ?: "",
            user.isBlock ?: "",
            user.roleUser ?: "",
            user.agentDate ?: "",
            user.agentId ?: "",
            user.agentExpair ?: "",
            user.meliCard ?: "",
            user.domin ?: "",
            user.subdomin ?: "",
            user.flagdomin ?: ""
        )
    }
}