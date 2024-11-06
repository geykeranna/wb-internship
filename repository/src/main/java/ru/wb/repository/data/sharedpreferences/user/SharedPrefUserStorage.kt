package ru.wb.repository.data.sharedpreferences.user

import android.content.Context
import ru.wb.repository.data.sharedpreferences.Storage

private const val SHARED_PREFS_NAME_TOKEN = "shared_prefs_user_name_token"
private const val KEY_TOKEN = "user_key_token"

internal class SharedPrefUserStorage(
    context: Context
) : Storage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME_TOKEN, Context.MODE_PRIVATE)

    override fun saveValue(token: String): Boolean {
        try {
            sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
            return true
        } catch (error: Exception) {
            return false
        }
    }

    override fun getValue(): String {
        return sharedPreferences.getString(KEY_TOKEN, "") ?: ""
    }
}