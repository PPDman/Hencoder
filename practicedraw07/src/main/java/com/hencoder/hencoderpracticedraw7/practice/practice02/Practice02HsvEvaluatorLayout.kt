package com.hencoder.hencoderpracticedraw7.practice.practice02

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
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
        // 重写 evaluate() 方法，让颜色按照 HSV 来变化
        override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
            return startValue
        }
    }
}