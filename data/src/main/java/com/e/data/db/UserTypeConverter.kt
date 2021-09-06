package com.e.data.db

import androidx.room.TypeConverter
import com.e.data.entity.local.User
import org.json.JSONObject

class UserTypeConverter {
    @TypeConverter
    fun fromUser(user: User): String {
        return JSONObject().apply {
            put("id", user.id)
            put("ids", user.ids)
            put("role", user.role)
            put("loginType", user.loginType)
            put("firstName", user.firstName)
            put("lastName", user.lastName)
            put("email", user.email)
            put("userName", user.userName)
            put("phone", user.phone)
            put("verifyPhone", user.verifyPhone)
            put("timeZone", user.timeZone)
            put("moreInformation", user.moreInformation)
            put("settings", user.settings)
            put("desc", user.desc)
            put("balance", user.balance)
            put("customRate", user.customRate)
            put("apiKey", user.apiKey)
            put("spent", user.spent)
            put("activationKey", user.activationKey)
            put("resetKey", user.resetKey)
            put("historyIp", user.historyIp)
            put("status", user.status)
            put("changed", user.changed)
            put("created", user.created)
            put("ref", user.ref)
            put("profitRate", user.profitRate)
            put("alfa", user.alfa)
            put("minharvest", user.minharvest)
            put("cardNumber", user.cardNumber)
            put("shNumber", user.shNumber)
            put("accountName", user.accountName)
            put("bankName", user.bankName)
            put("verifyBank", user.verifyBank)
            put("verifyMore", user.verifyMore)
            put("birthday", user.birthday)
            put("education", user.education)
            put("marry", user.marry)
            put("sex", user.sex)
            put("avatar", user.avatar)
            put("isBlock", user.isBlock)
            put("roleUser", user.roleUser)
            put("agentDate", user.agentDate)
            put("agentId", user.agentId)
            put("agentExpair", user.agentExpair)
            put("meliCard", user.meliCard)
            put("domin", user.domin)
            put("subdomin", user.subdomin)
            put("flagdomin", user.flagdomin)
        }.toString()
    }

    @TypeConverter
    fun toSource(user: String): User {
        val json = JSONObject(user)
        return User(
            json.getInt("id"),
            json.getInt("ids"),
            json.getString("role"),
            json.getString("loginType"),
            json.getString("firstName"),
            json.getString("lastName"),
            json.getString("email"),
            json.getString("userName"),
            json.getString("phone"),
            json.getString("verifyPhone"),
            json.getString("timeZone"),
            json.getString("moreInformation"),
            json.getString("settings"),
            json.getString("desc"),
            json.getString("balance"),
            json.getString("customRate"),
            json.getString("apiKey"),
            json.getString("spent"),
            json.getString("activationKey"),
            json.getString("resetKey"),
            json.getString("historyIp"),
            json.getString("status"),
            json.getString("changed"),
            json.getString("created"),
            json.getString("ref"),
            json.getString("profitRate"),
            json.getString("alfa"),
            json.getString("minharvest"),
            json.getString("cardNumber"),
            json.getString("shNumber"),
            json.getString("accountName"),
            json.getString("bankName"),
            json.getString("verifyBank"),
            json.getString("verifyMore"),
            json.getString("birthday"),
            json.getString("education"),
            json.getString("marry"),
            json.getString("sex"),
            json.getString("avatar"),
            json.getString("isBlock"),
            json.getString("roleUser"),
            json.getString("agentDate"),
            json.getString("agentId"),
            json.getString("agentExpair"),
            json.getString("meliCard"),
            json.getString("domin"),
            json.getString("subdomin"),
            json.getString("flagdomin")
        )
    }
}