package com.alexanderkhyzhun.ui.splash

import com.alexanderkhyzhun.ui.mvp.BaseView
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface SplashView : MvpView, BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun redirectToLogin()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun redirectToMain()

}
