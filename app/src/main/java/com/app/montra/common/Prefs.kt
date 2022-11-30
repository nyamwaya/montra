package com.app.montra.common

import Constants.PREFS_USER_ID
import Constants.SHARED_PREFS_NAME
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class Prefs @Inject constructor(
    private val context: Context
) {
    private val preferences: SharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    var stytechUserId: String?
        get() = preferences.getString(PREFS_USER_ID, "")
        set(value) = preferences.edit().putString(PREFS_USER_ID, value).apply()

}