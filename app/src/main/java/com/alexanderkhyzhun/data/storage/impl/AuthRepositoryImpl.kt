package com.alexanderkhyzhun.data.storage.impl

import com.alexanderkhyzhun.data.Api
import com.alexanderkhyzhun.data.storage.AuthRepository
import com.alexanderkhyzhun.data.storage.StorageRepository

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class AuthRepositoryImpl(
    private val storage: StorageRepository,
    private val api: Api
) : AuthRepository {

    override fun signIn() {

    }

    override fun isUserAuthorized(): Boolean {
        return false
    }


}