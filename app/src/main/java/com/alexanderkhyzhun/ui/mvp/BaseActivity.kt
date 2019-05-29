package com.alexanderkhyzhun.ui.mvp

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Dialog
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.alexanderkhyzhun.enums.Event
import com.alexanderkhyzhun.ui.mvp.moxy.MvpAppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.view.clicks
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit


open class BaseActivity : MvpAppCompatActivity() {


    private val subject: BehaviorSubject<Event> = BehaviorSubject.createDefault(Event.CREATE)

    override fun onDestroy() {
        super.onDestroy()
        subject.onNext(Event.DESTROY)
    }

    fun <T> bindUntilDestroy(): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(subject, Event.DESTROY)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBarColor(colorRes: Int) {
        window.statusBarColor = resources.getColor(colorRes)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun hideStatusBar() {
        val decor = window.decorView
        decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT
    }

    @SuppressLint("ObsoleteSdkInt")
    fun setTranslucentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    fun showSnack(msg: String?) {
        msg?.let {
            Snackbar.make(findViewById(android.R.id.content), it, Snackbar.LENGTH_LONG).show()
        }
    }

    fun setLightStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    companion object {
        const val COLUMN_COUNT_TWO = 2
        const val MIN_PASSWORD_LENGTH = 6
        const val FIELD_CHECK_DELAY = 400L
        const val CLICK_DEBOUNCE = 500L
        const val CLICK_DEBOUNCE_ITEM = 50L
        const val DELIMITER = "@"
        const val height4kPx = 4096
        const val width4kPx = 2160
        const val SEARCH_DEBOUNCE = 1000L
        const val MIN_LOADEABLE_RETRY_COUNT = 3
        const val PHONE_NUMBER_REGEX = "^[+][0-9]{10,13}\$"
    }
}
