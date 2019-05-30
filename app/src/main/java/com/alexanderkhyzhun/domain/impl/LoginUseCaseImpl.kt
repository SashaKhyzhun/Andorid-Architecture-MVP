package com.alexanderkhyzhun.domain.impl

import com.alexanderkhyzhun.data.storage.StorageRepository
import com.alexanderkhyzhun.domain.LoginUseCase

/**
 * @author Alexander Khyzhun
 * Created on 30 May, 2019
 */
class LoginUseCaseImpl(
    private val storage: StorageRepository
) : LoginUseCase {


    override fun createUserSession(firstName: String, lastName: String) {
        /**
         * you can do it here or create specific method
         * for that inside storage repository (as logout)
         */
        with(storage) {
            setFirstName(firstName)
            setLastName(lastName)
            setLoginStatus(true)
        }

    }

}