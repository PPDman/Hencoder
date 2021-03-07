package com.example.hencoderpracticedraw1.view

import android.content.res.Resources
import android.util.TypedValue

private val displayMetrics = Resources.getSystem().displayMetrics

fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}
