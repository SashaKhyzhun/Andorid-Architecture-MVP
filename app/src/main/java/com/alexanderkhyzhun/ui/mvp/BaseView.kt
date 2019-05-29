package com.alexanderkhyzhun.ui.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun renderError(throwable: Throwable)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun renderMessage(text: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showLoader()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hideLoader()

}