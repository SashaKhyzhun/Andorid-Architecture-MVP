package com.alexanderkhyzhun.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexanderkhyzhun.R
import com.alexanderkhyzhun.data.Schedulers
import com.alexanderkhyzhun.ui.mvp.BaseActivity
import com.alexanderkhyzhun.ui.splash.SplashActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity(), MainView {

    val schedulers: Schedulers by inject()

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main_btn_logout.clicks()
            .debounce(CLICK_DEBOUNCE, TimeUnit.MILLISECONDS)
            .compose(bindUntilDestroy())
            .observeOn(schedulers.mainThread())
            .subscribe { presenter.clickLogout() }
    }


    override fun updateUserName(userName: String) {
        activity_main_tv_user_name.text = userName
    }

    override fun onClickedLogout() {
        startActivity(SplashActivity.getIntent(this))
    }

    override fun renderError(throwable: Throwable) {
        showSnack(throwable.message)
    }

    override fun renderMessage(text: String) {
        showSnack(text)
    }

    override fun showLoader() {
        /* code implementation */
    }

    override fun hideLoader() {
        /* code implementation */
    }

    companion object {
        const val TAG = "MainActivity"
        fun getIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }

}
