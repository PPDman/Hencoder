package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice5DrawOvalView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private lateinit var paint: Paint


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint= Paint()

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        canvas?.drawOval(RectF(10f,20f,30f,40f),paint)
      }
}