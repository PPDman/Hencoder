package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample05ComposeShaderView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        val bitmap1=BitmapFactory.decodeResource(resources, R.drawable.batman)
        val shader1 = BitmapShader(bitmap1,Shader.TileMode.CLAMP,
        Shader.TileMode.CLAMP)
        val bitmap2=BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val shader2 = BitmapShader(bitmap2,Shader.TileMode.CLAMP,
            Shader.TileMode.CLAMP)
        paint.shader=ComposeShader(shader1,shader2,PorterDuff.Mode.DST_IN)
        paint
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}