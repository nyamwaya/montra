package com.app.montra.domain.use_cases.signup

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.AuthRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponseDto
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: StytchRepository
) {
    operator fun invoke(requestBody: AuthRequest): Flow<Resource<CreateUserWithPasswordResponseDto>> = flow {
        try {
            emit(Resource.Loading())
            val createUserWithPasswordResponse = repository.createUserWithPassword(requestBody)
            emit(Resource.Success(createUserWithPasswordResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, check your internet connection."))
        }
    }
}