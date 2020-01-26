package com.example.commonlib

import android.view.Window
import android.view.WindowManager

fun setFitNotch(window: Window?) {
    window?.apply {
        val lp = attributes
        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        attributes = lp
    }
}