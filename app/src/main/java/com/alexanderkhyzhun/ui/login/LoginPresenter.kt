package com.alexanderkhyzhun.ui.login

import com.alexanderkhyzhun.domain.LoginUseCase
import com.alexanderkhyzhun.ui.mvp.BasePresenter
import com.arellomobile.mvp.InjectViewState
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
@InjectViewState
class LoginPresenter : BasePresenter<LoginView>(), KoinComponent {

    private val useCase: LoginUseCase by inject()

    fun handleLoginCredentials(firstName: String, lastName: String) {
        if (firstName.isNotEmpty() && lastName.isNotEmpty()) {

            useCase.createUserSession(firstName, lastName)
            viewState.redirectToSplash()
        } else {
            viewState.renderMessage("Something wrong with your credentials")
        }
    }


}