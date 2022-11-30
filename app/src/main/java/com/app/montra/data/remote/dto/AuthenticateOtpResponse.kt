package com.app.montra.data.remote.dto

data class AuthenticateOtpResponse(
    val method_id: String,
    val request_id: String,
    val reset_sessions: Boolean,
    val session: Any,
    val session_jwt: String,
    val session_token: String,
    val status_code: Int,
    val user_id: String,
    val user: User
)