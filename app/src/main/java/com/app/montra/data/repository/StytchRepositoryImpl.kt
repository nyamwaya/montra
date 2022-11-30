package com.app.montra.data.repository

import com.app.montra.data.remote.StytchApi
import com.app.montra.data.remote.dto.*
import com.app.montra.domain.repository.StytchRepository
import javax.inject.Inject

class StytchRepositoryImpl @Inject constructor(
    private val api: StytchApi
) : StytchRepository {

    override suspend fun createUserWithPassword(requestBody: AuthRequest): CreateUserWithPasswordResponseDto {
        return api.signUp(requestBody)
    }

    override suspend fun updateUser(
        userId: String,
        requestBody: UpdateUserRequest
    ): UpdateUserResponseDto {
        return api.updateUser(userId, requestBody)
    }

    override suspend fun sendOtp(requestBody: EmailOnlyRequest): SendOtpResponseDto {
        return api.sendOtp(requestBody)
    }

    override suspend fun authenticateOtp(requestBody: AuthenticateOtpRequest): AuthenticateOtpResponseDto {
        return api.authenticateOtp(requestBody)
    }

    override suspend fun login(requestBody: AuthRequest): LoginResponseDto {
        return api.login(requestBody)
    }

    override suspend fun getUser(userId: String): GetUserResponseDto {
       return api.getUser(userId)
    }

    override suspend fun resetPassword(requestBOdy: EmailOnlyRequest): ResetPasswordResponseDto {
        return api.resetPassword(requestBOdy)
    }

}
