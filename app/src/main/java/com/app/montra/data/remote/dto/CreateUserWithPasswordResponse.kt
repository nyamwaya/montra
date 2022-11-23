package com.app.montra.data.remote.dto

data class CreateUserWithPasswordResponse(
    val email_id: String,
    val request_id: String,
    val session: Any,
    val session_jwt: String,
    val session_token: String,
    val status_code: Int,
    val user: User,
    val user_id: String
)