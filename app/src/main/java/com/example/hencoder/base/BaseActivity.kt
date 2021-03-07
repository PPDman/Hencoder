package com.example.hencoder.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hencoder.util.ActivityBox

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity", javaClass.simpleName)
        ActivityBox.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityBox.removeActivity(this)
    }
}