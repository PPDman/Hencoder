package com.hencoder.hencoderpracticelayout1.practice

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.Nullable

/**
 * 需要把它写成正方形的 ImageView
 */
@SuppressLint("AppCompatCustomView")
class Practice01SquareImageView : ImageView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    /**
     * 重写 onMeasure()，调整尺寸，让 ImageView 总是正方形
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 先用 getMeasuredWidth() 和 getMeasuredHeight() 取到 super.onMeasure() 的计算结果

        // 然后通过计算，让宽度和高度一致

        // 再用 setMeasuredDimension(width, height) 来保存最终的宽度和高度
    }
}