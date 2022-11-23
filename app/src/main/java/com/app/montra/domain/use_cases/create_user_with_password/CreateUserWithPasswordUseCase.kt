package com.app.montra.domain.use_cases.create_user_with_password

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CreateUserWithPasswordUseCase @Inject constructor(
    private val repository: StytchRepository
) {
    operator fun invoke(requestBody: CreateUserWithPasswordRequest): Flow<Resource<CreateUserWithPasswordResponse>> = flow {
        try {
            emit(Resource.Loading())
            val createUserWithPasswordResponse = repository.createUserWithPassword(requestBody)
            emit(Resource.Success(createUserWithPasswordResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, check your internet connection."))
        }
    }
}