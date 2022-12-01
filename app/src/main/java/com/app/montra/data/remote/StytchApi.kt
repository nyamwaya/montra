package com.app.montra.data.remote

import com.app.montra.data.remote.dto.*
import retrofit2.http.*

interface StytchApi {
    @POST("passwords")
    suspend fun signUp(
        @Body requestBody: AuthRequest
    ): CreateUserWithPasswordResponseDto

    @POST("passwords/authenticate")
    suspend fun login(
        @Body requestBody: AuthRequest
    ) : LoginResponseDto

    @PUT("users/{userId}")
    suspend fun updateUser(
        @Path("userId") string: String,
        @Body requestBody: UpdateUserRequest
    ): UpdateUserResponseDto

    @PUT("otps/email/send")
    suspend fun sendOtp(
        @Body requestBody: EmailOtpDto
    ): SendOtpResponseDto


    @PUT("otps/authenticate")
    suspend fun authenticateOtp(
        @Body requestBody: AuthenticateOtpRequest
    ): AuthenticateOtpResponseDto

    @GET("users/{userId}")
    suspend fun getUser(
        @Path("userId") string: String
    ) : GetUserResponseDto

    @POST("email/reset/start")
    suspend fun resetPassword(
        @Body resetPasswordRequest: EmailOnlyRequest
    ) : ResetPasswordResponseDto
}