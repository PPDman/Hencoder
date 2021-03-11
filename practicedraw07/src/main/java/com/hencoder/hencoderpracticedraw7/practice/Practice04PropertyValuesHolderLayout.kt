package com.hencoder.hencoderpracticedraw7.practice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw7.R

class Practice04PropertyValuesHolderLayout : RelativeLayout {
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
            // 使用 PropertyValuesHolder.ofFloat() 来创建不同属性的动画值方案
            // 第一个： scaleX 从 0 到 1
            // 第二个： scaleY 从 0 到 1
            // 第三个： alpha 从 0 到 1

            // 然后，用 ObjectAnimator.ofPropertyValuesHolder() 把三个属性合并，创建 Animator 然后执行
        }
    }
}