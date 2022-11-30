package com.app.montra.data.remote.dto

import com.app.montra.domain.models.UserModel

data class UpdateUserResponseDto(
    val crypto_wallets: List<CryptoWallet>,
    val emails: List<Email>,
    val phone_numbers: List<PhoneNumber>,
    val request_id: String,
    val status_code: Int,
    val user: User,
    val user_id: String
)

fun UpdateUserResponseDto.toUserModel() : UserModel{
    return UserModel(
        emails = emails,
        userId = user_id
    )
}
