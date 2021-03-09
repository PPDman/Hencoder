package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice01ClipRectView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val left = (width - bitmap!!.width) / 2
        val top = (height - bitmap!!.height) / 2

        //范围裁切要canvas.save
        canvas.save()
        canvas.clipRect(left + 50f, top + 50f, left + 300f, top + 200f)
        canvas.drawBitmap(bitmap!!, left.toFloat(), top.toFloat(), paint)
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }
}