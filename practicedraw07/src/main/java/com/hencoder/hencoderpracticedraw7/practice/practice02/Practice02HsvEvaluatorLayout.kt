package com.hencoder.hencoderpracticedraw7.practice.practice02

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw7.R

class Practice02HsvEvaluatorLayout : RelativeLayout {
    var view: Practice02HsvEvaluatorView? = null
    var animateBt: Button? = null

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
        view = findViewById<View>(R.id.objectAnimatorView) as Practice02HsvEvaluatorView
        animateBt = findViewById<View>(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            val animator = ObjectAnimator.ofInt(view, "color", -0x10000, -0xff0100)
            animator.setEvaluator(HsvEvaluator()) // 使用自定义的 HsvEvaluator
            animator.interpolator = LinearInterpolator()
            animator.duration = 2000
            animator.start()
        }
    }

    private inner class HsvEvaluator : TypeEvaluator<Int> {
        var startHsv = FloatArray(3)
        var endHsv = FloatArray(3)
        var outHsv = FloatArray(3)
        // 重写 evaluate() 方法，让颜色按照 HSV 来变化
        override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
            //把ARGB转换成HSV
            Color.colorToHSV(startValue,startHsv)
            Color.colorToHSV(endValue,endHsv)
            // 计算当前动画完成度（fraction）所对应的颜色值

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360f
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360f
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction
            if (outHsv[0] > 360) {
                outHsv[0] -= 360f
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360f
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction

            // 计算当前动画完成度（fraction）所对应的透明度

            // 计算当前动画完成度（fraction）所对应的透明度
            val alpha = startValue shr 24 + ((endValue shr 24 - startValue shr 24) * fraction).toInt()

            // 把 HSV 转换回 ARGB 返回

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha, outHsv)
        }
    }
}