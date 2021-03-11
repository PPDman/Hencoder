package com.hencoder.hencoderpracticedraw7.practice.practice01

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw7.R

class Practice01ArgbEvaluatorLayout : RelativeLayout {
    var view: Practice01ArgbEvaluatorView? = null
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
        view = findViewById<View>(R.id.objectAnimatorView) as Practice01ArgbEvaluatorView
        animateBt = findViewById<View>(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            val animator = ObjectAnimator.ofInt(view, "color", -0x10000, -0xff0100)
            // 在这里使用 ObjectAnimator.setEvaluator() 来设置 ArgbEvaluator，修复闪烁问题
            animator.interpolator = LinearInterpolator()
            animator.duration = 2000
            animator.start()
        }
    }
}