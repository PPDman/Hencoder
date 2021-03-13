package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.text.Layout
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatTextView

class Practice02BeforeOnDrawView : AppCompatTextView {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bounds: RectF = RectF()

    constructor(context: Context) : super(context) {}
    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {


        // 把下面的绘制代码移到 super.onDraw() 的上面，就可以让原主体内容盖住你的绘制代码了
        // （或者你也可以把 super.onDraw() 移到这段代码的下面）
        val layout: Layout = layout
        bounds.left = layout.getLineLeft(1)
        bounds.right = layout.getLineRight(1)
        bounds.top = layout.getLineTop(1).toFloat()
        bounds.bottom = layout.getLineBottom(1).toFloat()
        canvas.drawRect(bounds, paint)
        bounds.left = layout.getLineLeft(layout.lineCount - 4)
        bounds.right = layout.getLineRight(layout.lineCount - 4)
        bounds.top = layout.getLineTop(layout.lineCount - 4).toFloat()
        bounds.bottom = layout.getLineBottom(layout.lineCount - 4).toFloat()
        canvas.drawRect(bounds, paint)
        super.onDraw(canvas)
    }

    init {
        paint.color = Color.parseColor("#FFC107")
    }
}