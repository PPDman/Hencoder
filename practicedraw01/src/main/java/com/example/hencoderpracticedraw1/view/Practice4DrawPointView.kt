package com.example.hencoderpracticedraw1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice4DrawPointView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private lateinit var paint: Paint


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint= Paint()
//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        paint.strokeCap=Paint.Cap.ROUND
        canvas?.drawPoint(10f,20f,paint)
        paint.strokeCap=Paint.Cap.SQUARE
        canvas?.drawPoint(10f,20f,paint)
    }
}