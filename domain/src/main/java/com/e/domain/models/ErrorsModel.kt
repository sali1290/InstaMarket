package com.e.domain.models


data class ErrorsModel(
    var email: List<String>?,
    var password: List<String>?,
    var username: List<String>,
    var phoen: List<String>,
)
