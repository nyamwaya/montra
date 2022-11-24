package com.app.montra.data.remote.dto

data class UpdateUserResponse(
    val crypto_wallets: List<CryptoWallet>,
    val emails: List<Email>,
    val phone_numbers: List<PhoneNumber>,
    val request_id: String,
    val status_code: Int,
    val user: User,
    val user_id: String
)