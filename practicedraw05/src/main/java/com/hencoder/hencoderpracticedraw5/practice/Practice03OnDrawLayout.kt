package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout

class Practice03OnDrawLayout : LinearLayout {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var pattern: Pattern = Pattern()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        pattern.draw(canvas)
    }

    private inner class Pattern {
        var patternPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        var spots: Array<Spot?>

        constructor() {
            spots = arrayOfNulls(4)
            spots[0] = Spot(0.24f, 0.3f, 0.026f)
            spots[1] = Spot(0.69f, 0.25f, 0.067f)
            spots[2] = Spot(0.32f, 0.6f, 0.067f)
            spots[3] = Spot(0.62f, 0.78f, 0.083f)
        }

        private constructor(spots: Array<Spot?>) {
            this.spots = spots
        }

        fun draw(canvas: Canvas) {
            val repitition = Math.ceil((width.toFloat() / height).toDouble()).toInt()
            for (i in 0 until spots.size * repitition) {
                val spot = spots[i % spots.size]
                canvas.drawCircle(
                    i / spots.size * height * Companion.PATTERN_RATIO + spot!!.relativeX * height,
                    spot.relativeY * height,
                    spot.relativeSize * height,
                    patternPaint
                )
            }
        }

        private inner class Spot(
            val relativeX: Float,
            val relativeY: Float,
            val relativeSize: Float
        )


        init {
            patternPaint.color = Color.parseColor("#A0E91E63")
        }
    }

    companion object {
        private const val PATTERN_RATIO = 5f / 6
    }

    init {
        // ViewGroup 需要主动开启 dispatchDraw() 以外的绘制
        setWillNotDraw(false)
    }
}