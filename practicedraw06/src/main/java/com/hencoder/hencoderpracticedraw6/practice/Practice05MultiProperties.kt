package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.Utils

class Practice05MultiProperties : ConstraintLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var animated=false

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?,  attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?,  attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = findViewById<Button>(R.id.animateBt)
        imageView = findViewById<ImageView>(R.id.imageView)
        imageView!!.scaleX = 0f
        imageView!!.scaleY = 0f
        imageView!!.alpha = 0f
        animateBt!!.setOnClickListener {
            // TODO 在这里处理点击事件，同时对多个属性做动画
            if (!animated){
                imageView?.let {
                    it.animate()
                        .translationX(Utils.dpToPixel(200f))
                        .rotation(360f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(1f)
                }
            }else{
                imageView?.let {
                    it.animate()
                        .translationX(0f)
                        .rotation(0f)
                        .scaleX(0f)
                        .scaleY(0f)
                        .alpha(0f)
                }

            }
            animated=!animated
        }
    }
}