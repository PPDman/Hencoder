package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import com.hencoder.hencoderpracticedraw6.R

class Practice02Rotation : RelativeLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var state=0

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
        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView
        animateBt!!.setOnClickListener {
          imageView?.let {
              when (state) {
                  0-> it.animate().rotation(180f)
                  1-> it.animate().rotation(0f)
                  2-> it.animate().rotationX(180f)
                  3-> it.animate().rotationX(0f)
                  4-> it.animate().rotationY(180f)
                  5-> it.animate().rotationY(0f)
              }
              state++
              if (state==6)
                  state=0
          }
        }
    }
}