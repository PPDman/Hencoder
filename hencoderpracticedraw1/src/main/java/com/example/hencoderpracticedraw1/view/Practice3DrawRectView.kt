package com.example.hencoderpracticedraw1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice3DrawRectView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private lateinit var  paint:Paint

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint= Paint()
//        练习内容：使用 canvas.drawRect() 方法画矩形
        canvas?.drawRect(10f,20f,30f,40f,paint)
        canvas?.drawRect(Rect(10,20,30,40),paint)
        canvas?.drawRect(RectF(10f,20f,30f,40f),paint)
    }
}

