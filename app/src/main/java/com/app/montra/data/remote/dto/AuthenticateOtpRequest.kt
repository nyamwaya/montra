package com.app.montra.data.remote.dto

data class AuthenticateOtpRequest(
    val methodId: String,
    val otpCode: Int
)