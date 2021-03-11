package com.hencoder.hencoderpracticelayout1.common

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import com.hencoder.hencoderpracticelayout1.R
import com.hencoder.hencoderpracticelayout1.Utils

/**
 * 这个类是用来做 ImageView 外部的可调整框架的，不必关注
 */
class Common01AdjustablePanel : RelativeLayout {
    var parentLayout: FrameLayout? = null
    var heightBar: AppCompatSeekBar? = null
    var widthBar: AppCompatSeekBar? = null
    var bottomMargin = Utils.dpToPixel(48f)
    var minWidth = Utils.dpToPixel(80f)
    var minHeight = Utils.dpToPixel(100f)

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    protected override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        parentLayout = findViewById<FrameLayout>(R.id.parentLayout)
        widthBar = findViewById(R.id.widthBar)
        heightBar = findViewById(R.id.heightBar)
        val listener: SeekBar.OnSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, percent: Int, b: Boolean) {
                val layoutParams: RelativeLayout.LayoutParams =
                    parentLayout?.layoutParams as RelativeLayout.LayoutParams
                layoutParams.width = (minWidth + (this@Common01AdjustablePanel.getWidth()
                        - minWidth) * widthBar!!.progress / 100) as Int
                layoutParams.height = (minHeight + (this@Common01AdjustablePanel.getHeight()
                        - bottomMargin - minHeight) * heightBar!!.progress / 100) as Int
                parentLayout?.layoutParams = layoutParams
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        }
        widthBar?.setOnSeekBarChangeListener(listener)
        heightBar?.setOnSeekBarChangeListener(listener)
    }
}