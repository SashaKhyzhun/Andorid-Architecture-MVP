package com.alexanderkhyzhun.data.storage.impl

import android.content.SharedPreferences
import com.alexanderkhyzhun.data.storage.StorageRepository
import kotlin.math.log

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class StorageRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : StorageRepository {

    override fun setFirstName(first: String) {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, first).apply()
    }

    override fun setLastName(last: String) {
        sharedPreferences.edit().putString(KEY_LAST_NAME, last).apply()
    }

    override fun setLoginStatus(login: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_LOGIN_STATUS, login).apply()
    }

    override fun getFirstName(): String? = sharedPreferences.getString(KEY_FIRST_NAME, null)


    override fun getLastName(): String? = sharedPreferences.getString(KEY_LAST_NAME, null)

    override fun getLoginStatus(): Boolean = sharedPreferences.getBoolean(KEY_LOGIN_STATUS, false)


    override fun logout() {
        with (sharedPreferences.edit()) {
            clear()
            putBoolean(KEY_LOGIN_STATUS, false)
            apply()
        }
    }

    companion object {
        private const val KEY_FIRST_NAME = "key_first_name"
        private const val KEY_LAST_NAME = "key_last_name"
        private const val KEY_LOGIN_STATUS = "key_login_status"
    }

}