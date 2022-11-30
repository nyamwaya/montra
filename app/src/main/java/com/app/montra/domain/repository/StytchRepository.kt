package com.app.montra.domain.repository

import com.app.montra.data.remote.dto.*

interface StytchRepository {
    suspend fun createUserWithPassword(requestBody: LoginRequest) : CreateUserWithPasswordResponse
    suspend fun updateUser(userId: String, requestBody: UpdateUserRequest) : UpdateUserResponseDto
    suspend fun sendOtp(requestBody: SendOtpRequest) : SendOtpResponse
    suspend fun authenticateOtp(requestBody: AuthenticateOtpRequest) : AuthenticateOtpResponse
    suspend fun login(requestBody: LoginRequest) : LoginResponse
    suspend fun getUser(userId: String) : GetUserResponse
}