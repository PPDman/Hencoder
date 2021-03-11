package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView

class Practice05MultiProperties : ConstraintLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    protected fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = findViewById(R.id.animateBt) as Button?
        imageView = findViewById(R.id.imageView) as ImageView?
        imageView!!.scaleX = 0f
        imageView!!.scaleY = 0f
        imageView!!.alpha = 0f
        animateBt!!.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
            }
        })
    }
}