package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice12PathEffectView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()

    private val cornerPathEffect by lazy {  CornerPathEffect(20f)}
    private val discretePathEffect: PathEffect = DiscretePathEffect(20f, 5f)
    private val dashPathEffect: PathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
    private var pathDashPathEffect: PathEffect? = null
    private val sumPathEffect: PathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
    private val composePathEffect: PathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.pathEffect=cornerPathEffect
        canvas.drawPath(path, paint)
        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        paint.pathEffect=discretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(0f, 200f)
        paint.pathEffect=dashPathEffect
        // 第三处：DashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(500f, 200f)
        paint.pathEffect=pathDashPathEffect
        // 第四处：PathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(0f, 400f)
        paint.pathEffect=sumPathEffect
        // 第五处：SumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(500f, 400f)
        paint.pathEffect=composePathEffect
        // 第六处：ComposePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
    }

    init {
        paint.style = Paint.Style.STROKE
        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        val dashPath = Path()
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        pathDashPathEffect = PathDashPathEffect(dashPath, 50f, 0f, PathDashPathEffect.Style.MORPH)
    }
}