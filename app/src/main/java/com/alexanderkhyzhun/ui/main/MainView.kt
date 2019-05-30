package com.alexanderkhyzhun.ui.main

import com.alexanderkhyzhun.ui.mvp.BaseView
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface MainView : MvpView, BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun updateUserName(userName: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onClickedLogout()

}
