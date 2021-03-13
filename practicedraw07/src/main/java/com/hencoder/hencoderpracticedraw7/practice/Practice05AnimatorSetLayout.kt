package com.hencoder.hencoderpracticedraw7.practice

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw7.R

class Practice05AnimatorSetLayout : RelativeLayout {
    var view: View? = null
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
        view = findViewById(R.id.objectAnimatorView)
        animateBt = findViewById<View>(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            view?.translationX = -200f
            val animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
            val animator2 = ObjectAnimator.ofFloat(view, "translationX", -200f, 200f)
            val animator3 = ObjectAnimator.ofFloat(view, "rotation", 0f, 1080f)
            animator3.duration = 1000
            val animatorSet = AnimatorSet()
            // 用 AnimatorSet 的方法来让三个动画协作执行
            // 要求 1： animator1 先执行，animator2 在 animator1 完成后立即开始
            // 要求 2： animator2 和 animator3 同时开始
            animatorSet.start()
        }
    }
}