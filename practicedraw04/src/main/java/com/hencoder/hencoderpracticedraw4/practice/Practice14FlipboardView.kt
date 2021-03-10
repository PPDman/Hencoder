package com.hencoder.hencoderpracticedraw4.practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpracticedraw4.R

class Practice14FlipboardView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var camera = Camera()
    var degree = 0f
    var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree.toFloat()
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val bitmapWidth = bitmap!!.width
        val bitmapHeight = bitmap!!.height
        val centerX = width / 2f
        val centerY = height / 2f
        val x = centerX - bitmapWidth / 2f
        val y = centerY - bitmapHeight / 2f

       //绘制上部分
        canvas.save()
        canvas.clipRect(0f, 0f, width.toFloat(), centerY)
        canvas.drawBitmap(bitmap!!, x, y, paint)
        canvas.restore()

        //绘制下部分
        canvas.save()

        if (degree<90){
            canvas.clipRect(0f, centerY, width.toFloat(), height.toFloat())
        }else{
            canvas.clipRect(0f, 0f, width.toFloat(), centerY)
        }
        camera.save()
        camera.rotateX(degree)
        canvas.translate(centerX,centerY)
        camera.applyToCanvas(canvas)
        canvas.translate(-centerX, -centerY)
        camera.restore()

        canvas.drawBitmap(bitmap!!,x,y,paint)
        canvas.restore()
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
    }
}