package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import com.hencoder.hencoderpracticedraw6.R

class Practice03Scale : RelativeLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var  state=0
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?,  attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView
        animateBt!!.setOnClickListener {
            // TODO 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
            imageView?.let {
                when (state) {
                    0-> it.animate().scaleX(1.5f)
                    1-> it.animate().scaleX(1f)
                    2-> it.animate().scaleY(.5f)
                    3-> it.animate().scaleY(1f)
                }
                state++
                if (state == 4) {
                    state=0
                }
            }
        }
    }
}