package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice2DrawCircleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private lateinit var paint: Paint


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint = Paint()

        //1
        canvas?.let {
            it.drawCircle(200f,200f,200f,paint)
            paint.style=Paint.Style.STROKE
            it.drawCircle(200f,200f,200f,paint)
            paint.color= Color.BLUE
            it.drawCircle(200f,200f,200f,paint)
            paint.strokeWidth=40f
            it.drawCircle(200f,200f,200f,paint)
        }
    }
}
