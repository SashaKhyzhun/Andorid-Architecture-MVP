package com.alexanderkhyzhun

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.alexanderkhyzhun.di.AppModule
import com.alexanderkhyzhun.utils.ThreadAwareTree
import org.koin.android.ext.android.startKoin
import timber.log.Timber

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        context = this

        startKoin(
            androidContext = this,
            modules = listOf(AppModule(this).appModule),
            logger = AppModule.getLogger()
        )


        if (BuildConfig.DEBUG) {
            Timber.plant(ThreadAwareTree)
        }
        Timber.d("Application is created")

        //if (BuildConfig.ENABLE_CRASHLYTICS) {
        //    Fabric.with(this, Crashlytics())
        //}

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
            private set
    }

}