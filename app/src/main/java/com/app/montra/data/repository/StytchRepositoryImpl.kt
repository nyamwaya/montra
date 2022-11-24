package com.app.montra.data.repository

import com.app.montra.data.remote.StytchApi
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.data.remote.dto.UpdateUserRequest
import com.app.montra.data.remote.dto.UpdateUserResponse
import com.app.montra.domain.repository.StytchRepository
import javax.inject.Inject

class StytchRepositoryImpl @Inject constructor(
    private val api: StytchApi
) : StytchRepository {

    override suspend fun createUserWithPassword(requestBody: CreateUserWithPasswordRequest): CreateUserWithPasswordResponse {
        return api.createUserWithPassword(requestBody)
    }

    override suspend fun updateUser(userId: String, requestBody: UpdateUserRequest): UpdateUserResponse {
       return api.updateUser(userId, requestBody)
    }

}
