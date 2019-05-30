package com.alexanderkhyzhun.domain.impl

import com.alexanderkhyzhun.data.storage.StorageRepository
import com.alexanderkhyzhun.domain.MainUseCase

/**
 * @author Alexander Khyzhun
 * Created on 30 May, 2019
 */
class MainUseCaseImpl(
    private val storage: StorageRepository
) : MainUseCase {

    override fun retrieveUserName(): String {
        return "${storage.getFirstName()} ${storage.getLastName()}"
    }

    override fun logout() {
        storage.logout()
    }

}