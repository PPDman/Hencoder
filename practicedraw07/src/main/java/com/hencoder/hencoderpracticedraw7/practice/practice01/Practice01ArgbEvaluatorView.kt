package com.hencoder.hencoderpracticedraw7.practice.practice01

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class Practice01ArgbEvaluatorView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var color1 = -0x10000

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    fun getColor(): Int {
        return color1
    }

    fun setColor(color: Int) {
        this.color1 = color
        invalidate()
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width
        val height = height
        paint.color = color1
        canvas.drawCircle(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            (width / 6).toFloat(),
            paint
        )
    }
}