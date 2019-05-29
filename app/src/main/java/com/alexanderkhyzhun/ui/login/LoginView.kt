package com.alexanderkhyzhun.ui.login

import com.alexanderkhyzhun.ui.mvp.BaseView
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface LoginView : MvpView, BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun redirectToSplash()

}
