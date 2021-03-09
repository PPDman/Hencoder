package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView : View {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var texts = arrayOf<String>("A", "a", "J", "j", "Â", "â")
    var yOffsets = arrayOf<Int>(0, 0, 0, 0, 0, 0)
    var top = 200f
    var bottom = 400f

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(50f, top.toFloat(), (width - 50).toFloat(), bottom.toFloat(), paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        val middle = (top + bottom) / 2
        canvas.drawText(texts[0], 100f, middle+yOffsets[0], paint2)
        canvas.drawText(texts[1], 200f, middle+yOffsets[1], paint2)
        canvas.drawText(texts[2], 300f, middle+yOffsets[2], paint2)
        canvas.drawText(texts[3], 400f, middle+yOffsets[3], paint2)
        canvas.drawText(texts[4], 500f, middle+yOffsets[4], paint2)
        canvas.drawText(texts[5], 600f, middle+yOffsets[5], paint2)
    }

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f

        val textBounds=Rect()
        for (i in 0..5) {
            paint2.getTextBounds(texts[i],0,texts[i].length,textBounds)
            yOffsets[i]=-(textBounds.top+textBounds.bottom)/2
        }

    }
}