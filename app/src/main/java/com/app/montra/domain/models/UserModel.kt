package com.app.montra.domain.models

import android.os.Parcelable
import com.app.montra.data.remote.dto.Email
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val emails: List<Email>,
    val userId: String
) : Parcelable