package com.app.montra.domain.models

import android.os.Parcelable
import com.app.montra.data.remote.dto.Email
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val email: Email,
    val isEmailVerified: Boolean,
    val userId: String
) : Parcelable