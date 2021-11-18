package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgentList(
    @Json(name = "data")
    val agentList: MutableList<Agents>
)
