package com.app.montra.data.remote.dto

data class StytchErrorResponse(
    val error_message: String,
    val error_type: String,
    val error_url: String,
    val request_id: String,
    val status_code: Int
)