package com.alexanderkhyzhun.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexanderkhyzhun.R
import com.alexanderkhyzhun.data.Schedulers
import com.alexanderkhyzhun.ui.login.LoginActivity
import com.alexanderkhyzhun.ui.main.MainActivity
import com.alexanderkhyzhun.ui.mvp.BaseActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class SplashActivity : BaseActivity(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1500L)
            presenter.handleUserAuthStatus()
        }

    }

    override fun redirectToLogin() {
        startActivity(LoginActivity.getIntent(this))
    }

    override fun redirectToMain() {
        startActivity(MainActivity.getIntent(this))
    }

    override fun renderError(throwable: Throwable) {
        showSnack(throwable.message)
    }

    override fun renderMessage(text: String) {
        showSnack(text)
    }

    override fun showLoader() { /* implement */ }

    override fun hideLoader() { /* implement */ }


    companion object {
        const val TAG = "MainActivity"
        fun getIntent(context: Context?) = Intent(context, SplashActivity::class.java)
    }

}