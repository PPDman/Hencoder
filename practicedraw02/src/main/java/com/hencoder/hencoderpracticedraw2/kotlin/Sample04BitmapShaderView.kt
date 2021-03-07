package com.hencoder.hencoderpracticedraw2.kotlin

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample04BitmapShaderView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val bitmap=BitmapFactory.decodeResource(resources, R.drawable.batman)
        paint.shader = BitmapShader(bitmap,Shader.TileMode.CLAMP,
        Shader.TileMode.CLAMP)
        paint
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}