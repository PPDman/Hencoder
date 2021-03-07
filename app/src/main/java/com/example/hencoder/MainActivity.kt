package com.example.hencoder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hencoder.util.open

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSharedPreferences("data", MODE_PRIVATE).open {
            putBoolean("h",true)
            putString("aa","11")
        }
    }

    /**
     * 泛型高阶函数用法
     */
    inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
        val intent = Intent(context, T::class.java)
        block(intent)
        context.startActivity(intent)
    }
}