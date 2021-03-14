package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.Utils

class Practice06Duration : LinearLayout {
    var durationSb: SeekBar? = null
    var durationValueTv: TextView? = null
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var duration:Long = 300L
    var translationState=0

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?,  attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        durationSb = findViewById<View>(R.id.durationSb) as SeekBar
        durationValueTv = findViewById<View>(R.id.durationValueTv) as TextView
        durationValueTv!!.text = context.getString(R.string.ms_with_value, duration)
        durationSb!!.max = 10
        durationSb!!.progress = 1
        durationSb!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                duration = progress * 300L
                durationValueTv!!.text = context.getString(R.string.ms_with_value, duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView
        animateBt!!.setOnClickListener {
            // TODO 在这里处理点击事件，执行动画。记得使用 `setDuration(duration)` 来设置动画的时长。
            when (translationState) {
                0->imageView?.animate()?.translationX(Utils.dpToPixel(100f))?.duration=duration
                1->imageView?.animate()?.translationX(0f)?.duration=duration
            }
            if (translationState < 1) {
                translationState++
            }else{
                translationState=0
            }
        }
    }
}