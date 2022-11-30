package com.app.montra.data.remote

import com.app.montra.data.remote.dto.*
import retrofit2.http.*

interface StytchApi {
    @POST("passwords")
    suspend fun signUp(
        @Body requestBody: LoginRequest
    ): CreateUserWithPasswordResponse

    @POST("passwords/authenticate")
    suspend fun login(
        @Body requestBody: LoginRequest
    ) : LoginResponse

    @PUT("users/{userId}")
    suspend fun updateUser(
        @Path("userId") string: String,
        @Body requestBody: UpdateUserRequest
    ): UpdateUserResponseDto

    @PUT("otps/email/send")
    suspend fun sendOtp(
        @Body requestBody: SendOtpRequest
    ): SendOtpResponse


    @PUT("otps/authenticate")
    suspend fun authenticateOtp(
        @Body requestBody: AuthenticateOtpRequest
    ): AuthenticateOtpResponse

    @GET("users/{userId}")
    suspend fun getUser(
        @Path("userId") string: String
    ) : GetUserResponse
}