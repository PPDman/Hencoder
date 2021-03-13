package com.hencoder.hencoderpracticedraw7.practice.practice03

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw7.Utils

class Practice03OfObjectView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var position1 = PointF()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?,  attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    fun getPosition(): PointF {
        return position1
    }

    fun setPosition(position: PointF?) {
        if (position != null) {
            this.position1.set(position)
            invalidate()
        }
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val innerPaddingLeft = RADIUS * 1
        val innterPaddingRight = RADIUS * 1
        val innterPaddingTop = RADIUS * 1
        val innterPaddingBottom = RADIUS * 3
        val width = width - innerPaddingLeft - innterPaddingRight - RADIUS * 2
        val height = height - innterPaddingTop - innterPaddingBottom - RADIUS * 2
        canvas.drawCircle(
            innerPaddingLeft + RADIUS + width * position1.x,
            innterPaddingTop + RADIUS + height * position1.y,
            RADIUS,
            paint
        )
    }

    companion object {
        val RADIUS = Utils.dpToPixel(20f)
    }

    init {
        paint.color = Color.parseColor("#009688")
    }
}