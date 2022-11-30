package com.app.montra.presentation.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.*
import com.app.montra.domain.use_cases.login.LoginUseCase
import com.app.montra.domain.use_cases.reset_password.ResetPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val resetPasswordUseCase: ResetPasswordUseCase
) : ViewModel(){
    private val _loginState = MutableStateFlow<Resource<LoginResponseDto>>(Resource.Loading(null))
    val loginState: StateFlow<Resource<LoginResponseDto>> = _loginState

    private val _resetPasswordState = MutableStateFlow<Resource<ResetPasswordResponseDto>>(Resource.Loading(null))
    val resetPasswordState: StateFlow<Resource<ResetPasswordResponseDto>> = _resetPasswordState

    fun login(
        loginRequest: AuthRequest,
    ) {
        loginUseCase(loginRequest).onEach { result ->
            _loginState.value = result
        }.launchIn(viewModelScope)
    }

    fun resetPassword(requestBody: EmailOnlyRequest) {
        resetPasswordUseCase(requestBody).onEach { result ->
            _resetPasswordState.value = result
        }.launchIn(viewModelScope)
    }

}