package com.app.montra.presentation.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.montra.common.MontraPreferences
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.GetUserResponseDto
import com.app.montra.domain.use_cases.get_user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    preferences: MontraPreferences,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _getUserState =
        MutableStateFlow<Resource<GetUserResponseDto>>(Resource.Loading(null))
    val getUserState: StateFlow<Resource<GetUserResponseDto>> = _getUserState

    val mSharedPrefs = preferences

    fun getUser(userId: String) {
        getUserUseCase(userId).onEach { result ->
            _getUserState.value = result
        }.launchIn(viewModelScope)
    }
}