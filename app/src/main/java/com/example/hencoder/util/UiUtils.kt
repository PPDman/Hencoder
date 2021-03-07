package com.example.hencoder.util

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.hencoder.base.BaseApplication

private val displayMetrics=Resources.getSystem().displayMetrics

fun dp2px(dp:Float):Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, displayMetrics)
}

fun toast(string: String){
    toast(string, Toast.LENGTH_SHORT)
}

fun toast(string: String, lengthShort: Int) {
    Toast.makeText(BaseApplication.currentApplication(), string, lengthShort).show()
}

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}

fun Int.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}