package com.example.androidinovation.util

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.text.TextPaint
import android.widget.TextView

object ApnaUtil {

     fun textColorGradent(view: TextView, startcolor: String, endcolor: String) {
        val paint: TextPaint = view.paint
        val width: Float = paint.measureText(view.text.toString())
        val shader = LinearGradient(
            0f,
            0f,
            0f,
            view.textSize,
            Color.parseColor(startcolor),
            Color.parseColor(endcolor),
            Shader.TileMode.CLAMP
        )
        view.paint.shader = shader
    }
}