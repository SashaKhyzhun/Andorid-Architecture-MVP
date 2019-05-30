package com.alexanderkhyzhun.ui.main

import com.alexanderkhyzhun.domain.MainUseCase
import com.alexanderkhyzhun.ui.mvp.BasePresenter
import com.arellomobile.mvp.InjectViewState
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * @author Alexander Khyzhun
 * Created on 30 May, 2019
 */
@InjectViewState
class MainPresenter : BasePresenter<MainView>(), KoinComponent {

    private val useCase: MainUseCase by inject()

    init {
        retrieveUserName()
    }

    private fun retrieveUserName() {
        val userName = useCase.retrieveUserName()
        viewState.updateUserName(userName)
    }

    fun clickLogout() {
        useCase.logout()
        viewState.onClickedLogout()
    }

}