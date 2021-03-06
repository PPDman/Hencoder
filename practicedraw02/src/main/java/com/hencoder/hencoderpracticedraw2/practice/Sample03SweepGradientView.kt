package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Sample03SweepGradientView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.shader = SweepGradient(
            300f, 300f, Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"))
        paint
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(300f, 300f, 200f, paint)
    }
}