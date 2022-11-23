package com.app.montra.util

import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.google.gson.Gson

fun requestBodyToJson(requestBody: CreateUserWithPasswordRequest): String {
    return Gson().toJson(requestBody)
}