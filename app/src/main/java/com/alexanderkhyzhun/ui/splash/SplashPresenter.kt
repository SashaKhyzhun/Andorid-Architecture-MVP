package com.alexanderkhyzhun.ui.splash

import com.alexanderkhyzhun.data.storage.AuthRepository
import com.alexanderkhyzhun.ui.mvp.BasePresenter
import com.arellomobile.mvp.InjectViewState
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
@InjectViewState
class SplashPresenter : BasePresenter<SplashView>(), KoinComponent {

    private val auth: AuthRepository by inject()


    fun handleUserAuthStatus() {
        if (auth.isUserAuthorized()) {
            redirectToMain()
        } else {
            redirectToLogin()
        }
    }

    private fun redirectToMain() {
        viewState.redirectToMain()
    }

    private fun redirectToLogin() {
        viewState.redirectToLogin()
    }

}