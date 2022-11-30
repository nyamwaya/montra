package com.app.montra.domain.use_cases.login

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.LoginRequest
import com.app.montra.data.remote.dto.LoginResponse
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: StytchRepository
) {
    operator fun invoke(requestBody: LoginRequest): kotlinx.coroutines.flow.Flow<Resource<LoginResponse>> =
        flow {
            try {
                emit(Resource.Loading())
                val loginResponse = repository.login(requestBody)
                emit(Resource.Success(loginResponse))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server, check your internet connection."))
            }
        }
}