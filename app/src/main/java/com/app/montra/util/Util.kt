package com.app.montra.util

import android.content.Context
import android.view.View
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

fun requestBodyToJson(requestBody: CreateUserWithPasswordRequest): String {
    return Gson().toJson(requestBody)
}

fun showSnackBar(msg: String, view: View, length: Int) {
    Snackbar.make(view, msg, length).show()
}