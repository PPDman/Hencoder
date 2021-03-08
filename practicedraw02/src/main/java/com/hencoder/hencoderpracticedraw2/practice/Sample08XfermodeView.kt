package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample08XfermodeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private val paint=Paint(Paint.ANTI_ALIAS_FLAG)
    private val xfermode1 by lazy { PorterDuffXfermode(PorterDuff.Mode.SRC) }
    private val xfermode2 by lazy { PorterDuffXfermode(PorterDuff.Mode.DST_IN) }
    private val xfermode3 by lazy { PorterDuffXfermode(PorterDuff.Mode.DST_OUT) }

    private val bitmap1 by lazy {
        val bitmap=BitmapFactory.decodeResource(resources,R.drawable.batman)
        bitmap
    }
    private val bitmap2 by lazy {
        val bitmap=BitmapFactory.decodeResource(resources,R.drawable.batman_logo)
        bitmap
    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val saveLayer = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        paint.xfermode=xfermode1
        canvas.drawBitmap(bitmap2,0f,0f,paint)
        paint.xfermode=null


        canvas.drawBitmap(bitmap1, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = xfermode2
        canvas.drawBitmap(bitmap2, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = xfermode3
        canvas.drawBitmap(bitmap2, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = null

        canvas.restoreToCount(saveLayer)
    }
}