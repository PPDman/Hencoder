package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample07ColorMatrixColorFilterView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val colorMatrix=ColorMatrix()
        colorMatrix.setSaturation(0f)
        val colorFilter=ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter=colorFilter
        paint
    }

    private val bitmap by lazy {
        val bitmap=BitmapFactory.decodeResource(resources,R.drawable.batman)
        bitmap
    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(bitmap, 0f, 0f, paint)


    }
}