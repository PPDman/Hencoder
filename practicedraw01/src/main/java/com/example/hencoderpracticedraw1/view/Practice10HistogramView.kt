package com.example.hencoderpracticedraw1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice10HistogramView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val linePaint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dp2px(1f)
        paint.color = Color.WHITE
        paint
    }

    private val histogramPaint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        paint
    }

    private val reatWidth = dp2px(40f).toInt()
    private val divider = dp2px(10f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        canvas.drawColor(Color.parseColor("#333333"))
        canvas.save()
        canvas.translate(5f, 40f)
        canvas.drawLine(0f, 0f, 0f, 600f, linePaint)
        canvas.drawLine(0f, 600f, 1800f, 600f, linePaint)
        drawRect(canvas, Rect(0,590,reatWidth,600),0)
        drawRect(canvas,Rect(0,570,reatWidth,600),1)
        drawRect(canvas,Rect(0,570,reatWidth,600),2)
        drawRect(canvas,Rect(0,400,reatWidth,600),3)
        drawRect(canvas,Rect(0,200,reatWidth,600),4)
        drawRect(canvas,Rect(0,100,reatWidth,600),5)
        drawRect(canvas,Rect(0,350,reatWidth,600),6)
        canvas.restore()
    }

    private fun drawRect(canvas: Canvas, rect: Rect, index: Int) {
        canvas.save()
        canvas.translate((index + 1) * divider + index * rect.width(), 0f)
        canvas.drawRect(rect,histogramPaint)
        canvas.restore()
    }
}