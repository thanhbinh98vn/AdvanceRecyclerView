package com.example.demorecyclerviewmutipleviewtype.util

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator



object AnimationUtil {

    fun expand(clView:View) {
        val prevHeight: Int = clView.height
        clView.visibility = View.VISIBLE
        ValueAnimator.ofInt(prevHeight,150).apply {
            duration = 2000
            interpolator = DecelerateInterpolator()
            this.addUpdateListener { animation ->
                clView.layoutParams.height = animation.animatedValue as Int
                clView.requestLayout()
            }
            start()
        }
    }

}