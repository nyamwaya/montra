package com.app.montra.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Email(
    val email: String,
    val email_id: String,
    val verified: Boolean
) : Parcelable