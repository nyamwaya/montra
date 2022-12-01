package com.app.montra.common

import Constants.PREFS_USER_MODEL
import Constants.SHARED_PREFS_NAME
import android.content.Context
import android.content.SharedPreferences
import com.app.montra.domain.models.UserModel
import com.app.montra.util.toJson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MontraPreferences @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    fun getUserModel(): String? {
        return prefs.getString(PREFS_USER_MODEL, "")
    }

    fun setUserModel(userModel: UserModel) {
        prefs.edit().putString(PREFS_USER_MODEL, toJson(userModel)).apply()
    }
}