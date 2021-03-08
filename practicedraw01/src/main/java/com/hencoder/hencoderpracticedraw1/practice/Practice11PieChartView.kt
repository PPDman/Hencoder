package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw1.dp2px

class Practice11PieChartView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private val oval= RectF(dp2px(50f), dp2px(50f), dp2px(250f), dp2px(250f))


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼
        //在同个椭圆的基础上画圆弧
        canvas.drawColor(Color.parseColor("#333333"))
        val paint=Paint(Paint.ANTI_ALIAS_FLAG)
        canvas.save()
        canvas.translate(-dp2px(2f), dp2px(2f))
        paint.color=Color.BLUE
        canvas.drawArc(oval,80f,105f,true,paint)
        canvas.restore()

        canvas.save()
        canvas.translate(-dp2px(8f),-dp2px(8f))
        paint.color=Color.RED
        canvas.drawArc(oval,185f,120f,true,paint)
        canvas.restore()

        canvas.save()
        paint.color=Color.YELLOW
        canvas.drawArc(oval,305f,55f,true,paint)
        canvas.restore()

        canvas.save()
        paint.color=Color.GRAY
        canvas.translate(dp2px(1f), dp2px(1f))
        canvas.drawArc(oval,0f,10f,true,paint)
        canvas.restore()

        canvas.save()
        paint.color=Color.DKGRAY
        canvas.drawArc(oval,10f,10f,true,paint)
        canvas.restore()

        canvas.save()
        canvas.translate(dp2px(2f), dp2px(2f))
        paint.color=Color.LTGRAY
        canvas.drawArc(oval,20f,60f,true,paint)
        canvas.restore()
    }
}