package com.app.montra.util

import android.view.View
import com.app.montra.domain.models.UserModel
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

fun showSnackBar(msg: String, view: View, length: Int) {
    Snackbar.make(view, msg, length).show()
}

fun fromJson(string: String): UserModel {
    return Gson().fromJson(string, UserModel::class.java)
}

fun toJson(userModel: UserModel): String {
    return Gson().toJson(userModel)
}

fun isEmailValid(toString: String): Boolean {
    return true
}

fun isNameValid(): Boolean {
    return true
}

fun isPasswordValid() {

}