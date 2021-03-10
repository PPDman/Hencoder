package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.Nullable

class Practice03OnDrawLayout : LinearLayout {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var pattern: Pattern = Pattern()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        pattern.draw(canvas)
    }

    inner class Pattern {
        var patternPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var spots: Array<Spot?>
        private  val PATTERN_RATIO = 5f / 6

        internal constructor() {
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
            val repitition = Math.ceil((width.toFloat() / height).toDouble())
                .toInt()
            for (i in 0 until spots.size * repitition) {
                val spot = spots[i % spots.size]
                canvas.drawCircle(
                    i / spots.size * height * PATTERN_RATIO + spot!!.relativeX * height,
                    spot.relativeY * height,
                    spot.relativeSize * height,
                    patternPaint
                )
            }
        }

        private inner class Spot internal constructor(
            val relativeX: Float,
            val relativeY: Float,
            val relativeSize: Float
        )



        init {
            patternPaint.color = Color.parseColor("#A0E91E63")
        }
    }
}