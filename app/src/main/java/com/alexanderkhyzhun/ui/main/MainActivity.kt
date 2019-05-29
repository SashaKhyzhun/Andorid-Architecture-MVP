package com.alexanderkhyzhun.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexanderkhyzhun.R
import com.alexanderkhyzhun.ui.mvp.BaseActivity
import com.alexanderkhyzhun.ui.splash.SplashActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val TAG = "MainActivity"
        fun getIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }

}
