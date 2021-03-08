package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice6DrawLineView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private lateinit var paint: Paint


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint= Paint()

//        练习内容：使用 canvas.drawLine() 方法画直线
        canvas?.drawLine(100f,100f,200f,200f,paint)
      }
}