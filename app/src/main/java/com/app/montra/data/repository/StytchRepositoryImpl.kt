package com.app.montra.data.repository

import com.app.montra.data.remote.StytchApi
import com.app.montra.data.remote.dto.*
import com.app.montra.domain.repository.StytchRepository
import javax.inject.Inject

class StytchRepositoryImpl @Inject constructor(
    private val api: StytchApi
) : StytchRepository {

    override suspend fun createUserWithPassword(requestBody: LoginRequest): CreateUserWithPasswordResponse {
        return api.signUp(requestBody)
    }

    override suspend fun updateUser(
        userId: String,
        requestBody: UpdateUserRequest
    ): UpdateUserResponseDto {
        return api.updateUser(userId, requestBody)
    }

    override suspend fun sendOtp(requestBody: SendOtpRequest): SendOtpResponse {
        return api.sendOtp(requestBody)
    }

    override suspend fun authenticateOtp(requestBody: AuthenticateOtpRequest): AuthenticateOtpResponse {
        return api.authenticateOtp(requestBody)
    }

    override suspend fun login(requestBody: LoginRequest): LoginResponse {
        return api.login(requestBody)
    }

    override suspend fun getUser(userId: String): GetUserResponse {
       return api.getUser(userId)
    }

}
