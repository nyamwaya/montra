package com.app.montra.data.remote.dto

data class LoginResponseDto(
    val request_id: String,
    val status_code: Int,
    val user_id: String
)