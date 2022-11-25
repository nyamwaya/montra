package com.app.montra.presentation.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.CreateUserWithPasswordResponse
import com.app.montra.data.remote.dto.UpdateUserRequest
import com.app.montra.data.remote.dto.UpdateUserResponse
import com.app.montra.domain.use_cases.create_user_with_password.CreateUserWithPasswordUseCase
import com.app.montra.domain.use_cases.update_user.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val createUserWithPasswordUseCase: CreateUserWithPasswordUseCase,
    private val updateUserUseCase: UpdateUserUseCase
) : ViewModel() {
    private val _createUserState =
        MutableStateFlow<Resource<CreateUserWithPasswordResponse>>(Resource.Loading(null))
    val createUserState: StateFlow<Resource<CreateUserWithPasswordResponse>> = _createUserState

    private val _updateUserState =
        MutableStateFlow<Resource<UpdateUserResponse>>(Resource.Loading(null))
    val updateUserState: StateFlow<Resource<UpdateUserResponse>> = _updateUserState

    fun createUser(createUserRequest: CreateUserWithPasswordRequest, updateUserRequest: UpdateUserRequest) {
        viewModelScope.launch {
            createUserWithPasswordUseCase(createUserRequest).collect { result ->
                _createUserState.value = result
                if (result.data != null)
                    updateUserUseCase(result.data.user_id, updateUserRequest).collect {
                        _updateUserState.value = it
                    }
            }
        }
    }
}