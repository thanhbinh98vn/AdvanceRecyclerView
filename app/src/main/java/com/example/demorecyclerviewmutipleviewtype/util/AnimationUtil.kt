package com.example.demorecyclerviewmutipleviewtype.util

import android.animation.ValueAnimator
import android.content.res.Resources
import android.view.View
import android.view.animation.DecelerateInterpolator

object AnimationUtil {

    fun expand(clView:View) {
        val height: Int = Resources.getSystem().displayMetrics.heightPixels / 6
        clView.visibility = View.VISIBLE
        ValueAnimator.ofInt(0, height).apply {
            duration = 1000
            interpolator = DecelerateInterpolator()
            this.addUpdateListener { animation ->
                clView.layoutParams.height = animation.animatedValue as Int
                clView.requestLayout()
            }
            start()
        }
    }
}