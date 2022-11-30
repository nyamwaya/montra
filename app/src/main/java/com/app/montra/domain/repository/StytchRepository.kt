package com.app.montra.domain.repository

import com.app.montra.data.remote.dto.*

interface StytchRepository {
    suspend fun createUserWithPassword(requestBody: AuthRequest) : CreateUserWithPasswordResponseDto
    suspend fun updateUser(userId: String, requestBody: UpdateUserRequest) : UpdateUserResponseDto
    suspend fun sendOtp(requestBody: EmailOnlyRequest) : SendOtpResponseDto
    suspend fun authenticateOtp(requestBody: AuthenticateOtpRequest) : AuthenticateOtpResponseDto
    suspend fun login(requestBody: AuthRequest) : LoginResponseDto
    suspend fun getUser(userId: String) : GetUserResponseDto
    suspend fun resetPassword(requestBOdy: EmailOnlyRequest) : ResetPasswordResponseDto
}