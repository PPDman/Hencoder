package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.Utils

class Practice01Translation : RelativeLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?,  attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    protected override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = findViewById<View>(R.id.animateBt) as Button?
        imageView = findViewById<View>(R.id.imageView) as ImageView?
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView!!.outlineProvider = MusicOutlineProvider()
        }
        animateBt!!.setOnClickListener {
            // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移
        }
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    internal inner class MusicOutlineProvider : ViewOutlineProvider() {
        var path = Path()
        override fun getOutline(view: View, outline: Outline) {
            outline.setConvexPath(path)
        }

        init {
            path.moveTo(0f, Utils.dpToPixel(10f))
            path.lineTo(Utils.dpToPixel(7f), Utils.dpToPixel(2f))
            path.lineTo(Utils.dpToPixel(116f), Utils.dpToPixel(58f))
            path.lineTo(Utils.dpToPixel(116f), Utils.dpToPixel(70f))
            path.lineTo(Utils.dpToPixel(7f), Utils.dpToPixel(128f))
            path.lineTo(0f, Utils.dpToPixel(120f))
            path.close()
        }
    }
}