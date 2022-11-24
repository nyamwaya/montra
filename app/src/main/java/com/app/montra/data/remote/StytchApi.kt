package com.app.montra.data.remote

import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.data.remote.dto.UpdateUserRequest
import com.app.montra.data.remote.dto.UpdateUserResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface StytchApi {
    @POST("passwords")
    suspend fun createUserWithPassword(
        @Body requestBody: CreateUserWithPasswordRequest
    ): CreateUserWithPasswordResponse

    @PUT("users/{userId}")
    suspend fun updateUser(
        @Path("userId") string: String,
        @Body requestBody: UpdateUserRequest
    ) : UpdateUserResponse
}