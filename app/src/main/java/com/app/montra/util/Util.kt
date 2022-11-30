package com.app.montra.util

import android.view.View
import com.app.montra.data.remote.dto.StytchErrorResponse
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

fun showSnackBar(msg: String, view: View, length: Int) {
    Snackbar.make(view, msg, length).show()
}

fun fromJson(string: String) : StytchErrorResponse{
    return Gson().fromJson(string, StytchErrorResponse::class.java)
}
