package com.app.montra.domain.use_cases.create_user_with_password

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.UpdateUserRequest
import com.app.montra.data.remote.dto.UpdateUserResponse
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val repository: StytchRepository
) {
    operator fun invoke(userId: String, requestBody: UpdateUserRequest): Flow<Resource<UpdateUserResponse>> = flow {
        try {
            emit(Resource.Loading())
            val updateUserResponse = repository.updateUser(userId, requestBody)
            emit(Resource.Success(updateUserResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, check your internet connection."))
        }
    }
}