package com.alexanderkhyzhun.data.storage.impl

import android.content.SharedPreferences
import com.alexanderkhyzhun.data.storage.StorageRepository

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

    override fun getFirstName(): String? = sharedPreferences.getString(KEY_FIRST_NAME, null)


    override fun getLastName(): String? = sharedPreferences.getString(KEY_LAST_NAME, null)


    companion object {
        private const val KEY_FIRST_NAME = "key_first_name"
        private const val KEY_LAST_NAME = "key_last_name"
    }

}