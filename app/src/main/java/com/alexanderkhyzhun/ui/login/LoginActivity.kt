package com.alexanderkhyzhun.ui.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.alexanderkhyzhun.R
import com.alexanderkhyzhun.data.Schedulers
import com.alexanderkhyzhun.ui.mvp.BaseActivity
import com.alexanderkhyzhun.ui.splash.SplashActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import java.util.concurrent.TimeUnit

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class LoginActivity : BaseActivity(), LoginView {

    val schedulers: Schedulers by inject()

    @InjectPresenter
    lateinit var presenter: LoginPresenter


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        activity_login_btn_login.clicks()
            .debounce(CLICK_DEBOUNCE, TimeUnit.MILLISECONDS)
            .compose(bindUntilDestroy())
            .observeOn(schedulers.mainThread())
            .subscribe {
                presenter.handleLoginCredentials(
                    firstName = activity_login_et_first_name.text.toString(),
                    lastName = activity_login_et_last_name.text.toString()
                )
            }
    }

    override fun redirectToSplash() {
        startActivity(SplashActivity.getIntent(this))
    }

    override fun renderError(throwable: Throwable) {
        showSnack(throwable.message)
    }

    override fun renderMessage(text: String) {
        showSnack(text)
    }

    override fun showLoader() {
    }

    override fun hideLoader() {
    }

    companion object {
        const val TAG = "LoginActivity"
        fun getIntent(context: Context?) = Intent(context, LoginActivity::class.java)
    }


}