package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatImageView
import com.hencoder.hencoderpracticedraw5.R

class Practice01AfterOnDrawView : AppCompatImageView {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}
    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        // 爽吧？

        val drawable = drawable
        if (drawable != null) {
            canvas.save();
            canvas.concat(imageMatrix);
            val bounds = drawable.bounds;
            canvas.drawText(resources.getString(R.string.image_size, bounds.width(), bounds.height()), 20f, 40f, paint);
            canvas.restore();
        }
    }

    init {
        paint.color = Color.parseColor("#FFC107")
        paint.textSize = 28f
    }
}