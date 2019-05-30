package com.alexanderkhyzhun.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.alexanderkhyzhun.BuildConfig
import com.alexanderkhyzhun.data.Api
import com.alexanderkhyzhun.data.Schedulers
import com.alexanderkhyzhun.data.impl.ApiFactory
import com.alexanderkhyzhun.data.impl.InterceptorFactory
import com.alexanderkhyzhun.data.impl.OkHttpFactory
import com.alexanderkhyzhun.data.impl.SchedulersImpl
import com.alexanderkhyzhun.data.storage.StorageRepository
import com.alexanderkhyzhun.data.storage.impl.StorageRepositoryImpl
import com.alexanderkhyzhun.domain.LoginUseCase
import com.alexanderkhyzhun.domain.MainUseCase
import com.alexanderkhyzhun.domain.SplashUseCase
import com.alexanderkhyzhun.domain.impl.LoginUseCaseImpl
import com.alexanderkhyzhun.domain.impl.MainUseCaseImpl
import com.alexanderkhyzhun.domain.impl.SplashUseCaseImpl
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.logger.AndroidLogger
import org.koin.log.EmptyLogger

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
class AppModule(val context: Context) {

    val appModule = org.koin.dsl.module.module {

        /**
         * Tools
         */
        single { PreferenceManager.getDefaultSharedPreferences(context) } bind (SharedPreferences::class)
        single { GsonBuilder().create() }
        single { OkHttpClient().newBuilder() }
        single { InterceptorFactory(get(), get()) }
        single { OkHttpFactory(get()) }
        single { get<OkHttpFactory>().buildClient().build() }
        single { ApiFactory().create(Api::class.java, BuildConfig.BASE_API_URL, get()) }
        single { SchedulersImpl() } bind (Schedulers::class)
        single { Glide.with(context) }

        /**
         * Repositories
         */
        single { StorageRepositoryImpl(get()) } bind (StorageRepository::class)
        // single { AuthRepositoryImpl(get()) } bind (AuthRepository::class)
        // etc.


        /**
         * UseCases
         */
        single { SplashUseCaseImpl(get()) } bind (SplashUseCase::class)
        single { LoginUseCaseImpl(get()) } bind (LoginUseCase::class)
        single { MainUseCaseImpl(get()) } bind (MainUseCase::class)

    }

    companion object {
        fun getLogger() = when (BuildConfig.DEBUG) {
            true -> AndroidLogger()
            false -> EmptyLogger()
        }
    }

}