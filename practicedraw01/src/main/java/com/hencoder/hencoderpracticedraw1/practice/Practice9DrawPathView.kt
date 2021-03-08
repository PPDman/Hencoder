package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class Practice9DrawPathView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private lateinit var paint: Paint
    private lateinit var path:Path

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint = Paint()
        path= Path()
//        练习内容：使用 canvas.drawPath() 方法画心形
        path.addArc(200f,200f,400f,400f,-225f,225f)
        path.arcTo(400f,200f,600f,400f,-180f,225f,false)
        path.lineTo(400f,542f)

        canvas?.drawPath(path, paint)
    }
}