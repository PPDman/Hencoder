package com.example.hencoderpracticedraw1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class Practice8DrawArcView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private lateinit var paint: Paint


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint = Paint()
        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        canvas?.drawArc(RectF(10f, 20f, 30f, 40f), -90f, 90f, false, paint)
        canvas?.drawArc(RectF(10f, 20f, 30f, 40f), -90f, 90f, true, paint)
    }
}