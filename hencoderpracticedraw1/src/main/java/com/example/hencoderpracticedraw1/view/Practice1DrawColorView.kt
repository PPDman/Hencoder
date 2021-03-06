package com.example.hencoderpracticedraw1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

class Practice1DrawColorView(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr: Int
) : View(context,attributeSet,defStyleAttr) {

    constructor(
        context: Context,
        attributeSet: AttributeSet?
    ):this(context, attributeSet,0)

    constructor(context: Context):this(
        context,
        null
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
//        canvas?.drawColor(Color.YELLOW)
        canvas?.drawColor(Color.parseColor("#FFFFFF00"))
    }
}