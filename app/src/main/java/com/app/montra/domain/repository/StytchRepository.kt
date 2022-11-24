package com.app.montra.domain.repository

import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.data.remote.dto.UpdateUserRequest
import com.app.montra.data.remote.dto.UpdateUserResponse

interface StytchRepository {
    suspend fun createUserWithPassword(requestBody: CreateUserWithPasswordRequest) : CreateUserWithPasswordResponse
    suspend fun updateUser(userId: String, requestBody: UpdateUserRequest) : UpdateUserResponse
}