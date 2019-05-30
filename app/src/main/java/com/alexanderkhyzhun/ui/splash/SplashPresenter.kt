package com.alexanderkhyzhun.ui.splash

import com.alexanderkhyzhun.domain.SplashUseCase
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

    private val useCase: SplashUseCase by inject()

    fun handleUserAuthStatus() {
        if (useCase.isUserLoggedIn()) {
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