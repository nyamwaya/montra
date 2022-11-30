package com.app.montra.domain.use_cases.get_user

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.GetUserResponse
import com.app.montra.data.remote.dto.LoginResponse
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: StytchRepository
) {
    operator fun invoke(userId: String): kotlinx.coroutines.flow.Flow<Resource<GetUserResponse>> =
        flow {
            try {
                emit(Resource.Loading())
                val getUserResponse = repository.getUser(userId)
                emit(Resource.Success(getUserResponse))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server, check your internet connection."))
            }
        }
}