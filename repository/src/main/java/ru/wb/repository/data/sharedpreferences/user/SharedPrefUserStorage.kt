package ru.wb.repository.data.sharedpreferences.user

import android.content.Context
import ru.wb.repository.data.sharedpreferences.Storage

private const val SHARED_PREFS_NAME_TOKEN = "shared_prefs_user_name_token"
private const val KEY_TOKEN = "user_key_token"
private const val KEY_USER_PHONE = "user_key_phone"
private const val KEY_USER_NAME = "user_key_name"

internal class SharedPrefUserStorage(
    context: Context
) : Storage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME_TOKEN, Context.MODE_PRIVATE)

    override fun saveValue(value: String): Boolean {
        try {
            sharedPreferences.edit().putString(KEY_TOKEN, value).apply()
            return true
        } catch (error: Exception) {
            return false
        }
    }

    override fun getValue(): String {
        return sharedPreferences.getString(KEY_TOKEN, "") ?: ""
    }

    internal fun saveUserData(
        phone: String? = null,
        name: String? = null,
    ): Boolean {
        try {
            if(!phone.isNullOrBlank()) sharedPreferences.edit().putString(KEY_USER_PHONE, phone).apply()
            if(!name.isNullOrBlank()) sharedPreferences.edit().putString(KEY_USER_NAME, name).apply()
            return true
        } catch (error: Exception) {
            return false
        }
    }

    internal fun getPhone(): String {
        return sharedPreferences.getString(KEY_USER_PHONE, "") ?: ""
    }

    internal fun getName(): String {
        return sharedPreferences.getString(KEY_USER_NAME, "") ?: ""
    }
}