package com.hencoder.hencoderpracticedraw6.practice.practice08

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.hencoder.hencoderpracticedraw6.R
import java.util.*

class Practice08ObjectAnimatorLayout : RelativeLayout {
    var view: Practice08ObjectAnimatorView? = null
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
        view = findViewById<View>(R.id.objectAnimatorView) as Practice08ObjectAnimatorView
        animateBt = findViewById<View>(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
            // 1. 用 ObjectAnimator 创建 Animator 对象
            // 2. 用 start() 执行动画
            // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！方法
         val  animator= ObjectAnimator.ofInt(view,"progress",0,65)
            animator.duration=1000
            animator.interpolator=FastOutSlowInInterpolator()
            animator.start()
        }
    }
}