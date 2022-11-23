package com.app.montra.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.domain.use_cases.create_user_with_password.CreateUserWithPasswordUseCase
import com.app.montra.util.requestBodyToJson
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val createUserWithPasswordUseCase: CreateUserWithPasswordUseCase
) : ViewModel() {
    private val _createUserState =
        MutableStateFlow<Resource<CreateUserWithPasswordResponse>>(Resource.Loading(null))
    val createUserState: StateFlow<Resource<CreateUserWithPasswordResponse>> = _createUserState

    fun createUserWithPassword(requestBody: String) {
        viewModelScope.launch {
            createUserWithPasswordUseCase(requestBody).collect { result ->
                _createUserState.value = result
            }
        }
    }
}