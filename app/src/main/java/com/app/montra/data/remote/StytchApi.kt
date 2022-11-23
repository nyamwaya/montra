package com.app.montra.data.remote

import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface StytchApi {
    @POST("/passwords")
    suspend fun createUserWithPassword(
        @Body requestBody: String
    ): CreateUserWithPasswordResponse
}