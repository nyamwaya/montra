package com.app.montra.domain.repository

import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse

interface StytchRepository {
    suspend fun createUserWithPassword(requestBody: String) : CreateUserWithPasswordResponse
}