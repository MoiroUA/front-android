package io.moiro.vision.shared.managers

import android.content.Context
import android.content.SharedPreferences
import io.moiro.vision.R.string.app_name

class SessionManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}