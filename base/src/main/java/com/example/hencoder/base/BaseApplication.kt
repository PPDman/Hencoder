package com.example.hencoder.base

import android.app.Application
import android.content.Context
import com.example.hencoder.util.ActivityBox

class BaseApplication : Application() {
    companion object {
        lateinit var currentApplication: Context

        fun currentApplication(): Context? {
            return currentApplication
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }

    override fun onTerminate() {
        super.onTerminate()
        ActivityBox.finishAll()
    }
}