package com.app.montra.data.repository

import com.app.montra.data.remote.StytchApi
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.domain.repository.StytchRepository
import com.google.gson.Gson
import javax.inject.Inject

class StytchRepositoryImpl @Inject constructor(
    private val api: StytchApi
) : StytchRepository {
    override suspend fun createUserWithPassword(requestBody: String): CreateUserWithPasswordResponse {
       return api.createUserWithPassword(requestBody)
    }

}