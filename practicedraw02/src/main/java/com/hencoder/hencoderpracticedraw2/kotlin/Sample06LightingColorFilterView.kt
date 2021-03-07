package com.hencoder.hencoderpracticedraw2.kotlin

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample06LightingColorFilterView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint
    }

    private val bitmap by lazy {
        val bitmap=BitmapFactory.decodeResource(resources,R.drawable.batman)
        bitmap
    }

    private val colorFilter1 by lazy {
        val colorFilter1=LightingColorFilter(0x00ffff,0x000000)
        colorFilter1
    }
    private val colorFilter2 by lazy {
        val colorFilter2=LightingColorFilter(0xffffff,0x003000)
        colorFilter2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.colorFilter=colorFilter1
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        paint.colorFilter=colorFilter2
        canvas.drawBitmap(bitmap,bitmap.width+100f,0f,paint)

    }
}