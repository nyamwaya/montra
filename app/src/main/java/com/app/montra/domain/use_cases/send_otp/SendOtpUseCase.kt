package com.app.montra.domain.use_cases.send_otp

import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.EmailOnlyRequest
import com.app.montra.data.remote.dto.EmailOtpDto
import com.app.montra.data.remote.dto.SendOtpResponseDto
import com.app.montra.domain.repository.StytchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SendOtpUseCase @Inject constructor(
    private val repository: StytchRepository
){
    operator fun invoke(requestBody: EmailOtpDto): Flow<Resource<SendOtpResponseDto>> = flow {
        try {
            emit(Resource.Loading())
            val sendOtp = repository.sendOtp(requestBody)
            emit(Resource.Success(sendOtp))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, check your internet connection."))
        }
    }
}