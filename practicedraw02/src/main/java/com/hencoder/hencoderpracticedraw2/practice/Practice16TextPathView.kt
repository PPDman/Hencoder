package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice16TextPathView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPath = Path()
    var text = "Hello HenCoder"

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(text, 50f, 200f, paint)
        canvas.drawPath(textPath, pathPaint)
    }

    init {
        paint.textSize = 120f
        paint.getTextPath(text,0,text.length,50f,400f,textPath)
        // 使用 Paint.getTextPath() 来获取文字的 Path
        pathPaint.style = Paint.Style.STROKE
    }
}