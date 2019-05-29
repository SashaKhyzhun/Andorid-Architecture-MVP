package com.alexanderkhyzhun.ui.mvp

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.alexanderkhyzhun.enums.Event
import com.alexanderkhyzhun.ui.mvp.moxy.MvpAppCompatFragment
import com.jakewharton.rxbinding2.view.clicks
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit


open class BaseFragment : MvpAppCompatFragment() {

    private val subject: BehaviorSubject<Event> = BehaviorSubject.createDefault(Event.CREATE)

    override fun onDestroy() {
        super.onDestroy()
        subject.onNext(Event.DESTROY)
    }

    fun <T> bindUntilDestroy(): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(subject, Event.DESTROY)
    }

    fun showSnack(msg: String?) {
        msg?.let { (activity as? BaseActivity)?.showSnack(it) }
    }

}
