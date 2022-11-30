package com.app.montra.domain.use_cases.authenticate_otp

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.AuthenticateOtpRequest
import com.app.montra.data.remote.dto.AuthenticateOtpResponse
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthenticateOtpUseCase @Inject constructor(
    private val repository: StytchRepository
) {
    operator fun invoke(requestBody: AuthenticateOtpRequest): Flow<Resource<AuthenticateOtpResponse>> =
        flow {
            try {
                emit(Resource.Loading())
                val authenticateOtp = repository.authenticateOtp(requestBody)
                emit(Resource.Success(authenticateOtp))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server, check your internet connection."))
            }
        }
}