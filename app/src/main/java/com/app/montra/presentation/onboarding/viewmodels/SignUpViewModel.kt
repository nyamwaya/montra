package com.app.montra.presentation.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.montra.common.MontraPreferences
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.*
import com.app.montra.domain.use_cases.authenticate_otp.AuthenticateOtpUseCase
import com.app.montra.domain.use_cases.signup.SignUpUseCase
import com.app.montra.domain.use_cases.send_otp.SendOtpUseCase
import com.app.montra.domain.use_cases.update_user.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val sendOtpUseCase: SendOtpUseCase,
    private val authenticateOtpUseCase: AuthenticateOtpUseCase,
    sharedPrefs: MontraPreferences

) : ViewModel() {
    private val _createUserState =
        MutableStateFlow<Resource<CreateUserWithPasswordResponseDto>>(Resource.Loading(null))
    val createUserState: StateFlow<Resource<CreateUserWithPasswordResponseDto>> = _createUserState

    private val _updateUserState =
        MutableStateFlow<Resource<UpdateUserResponseDto>>(Resource.Loading(null))
    val updateUserState: StateFlow<Resource<UpdateUserResponseDto>> = _updateUserState

    private val _sendOtpState =
        MutableStateFlow<Resource<SendOtpResponseDto>>(Resource.Loading(null))
    val sendOtpState: StateFlow<Resource<SendOtpResponseDto>> = _sendOtpState

    private val _authenticateOtpState =
        MutableStateFlow<Resource<AuthenticateOtpResponseDto>>(Resource.Loading(null))
    val authenticateOtpState: StateFlow<Resource<AuthenticateOtpResponseDto>> = _authenticateOtpState

    val mSharedPrefs = sharedPrefs


    fun signUpUser(
        createUserRequest: AuthRequest,
    ) {
        signUpUseCase(createUserRequest).onEach { result ->
            _createUserState.value = result
        }.launchIn(viewModelScope)
    }

    fun updateUser(userId: String, updateUserRequest: UpdateUserRequest) {
        updateUserUseCase(userId, updateUserRequest).onEach { result ->
            _updateUserState.value = result
        }.launchIn(viewModelScope)
    }

    fun sendOtp(sendOtpRequest: EmailOtpDto) {
        sendOtpUseCase(sendOtpRequest).onEach { result ->
            _sendOtpState.value = result
        }.launchIn(viewModelScope)
    }

    fun authenticateOtp(authenticateOtpRequest: AuthenticateOtpRequest){
        authenticateOtpUseCase(authenticateOtpRequest).onEach { result ->
            _authenticateOtpState.value = result
        }.launchIn(viewModelScope)
    }


}