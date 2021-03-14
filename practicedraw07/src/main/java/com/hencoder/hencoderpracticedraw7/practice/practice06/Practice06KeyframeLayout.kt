package com.hencoder.hencoderpracticedraw7.practice.practice06

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.hencoder.hencoderpracticedraw7.R

class Practice06KeyframeLayout : RelativeLayout {
    var view: Practice06KeyframeView? = null
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
        view = findViewById<View>(R.id.objectAnimatorView) as Practice06KeyframeView
        animateBt = findViewById<View>(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            // 使用 Keyframe.ofFloat() 来为 view 的 progress 属性创建关键帧
            // 初始帧：progress 为 0
            // 时间进行到一般：progress 为 100
            // 结束帧：progress 回落到 80
            // 使用 PropertyValuesHolder.ofKeyframe() 来把关键帧拼接成一个完整的属性动画方案
            // 使用 ObjectAnimator.ofPropertyValuesHolder() 来创建动画
            val keyframe1 = Keyframe.ofFloat(0f, 0f)
            val keyframe2 = Keyframe.ofFloat(0.5f, 100f)
            val keyframe3 = Keyframe.ofFloat(1f, 80f)
            val holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3)
            val animator = ObjectAnimator.ofPropertyValuesHolder(view, holder)
            animator.duration = 2000
            animator.interpolator = FastOutSlowInInterpolator()
            animator.start()
        }
    }
}