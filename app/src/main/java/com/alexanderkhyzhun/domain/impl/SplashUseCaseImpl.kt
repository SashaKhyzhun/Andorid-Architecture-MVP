package com.alexanderkhyzhun.domain.impl

import com.alexanderkhyzhun.data.storage.StorageRepository
import com.alexanderkhyzhun.domain.SplashUseCase

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class SplashUseCaseImpl(
    private val storage: StorageRepository
) : SplashUseCase {

    override fun isUserLoggedIn(): Boolean = storage.getLoginStatus()

}