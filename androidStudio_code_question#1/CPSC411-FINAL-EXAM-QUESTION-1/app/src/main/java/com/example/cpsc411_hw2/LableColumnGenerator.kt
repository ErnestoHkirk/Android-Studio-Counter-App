package com.example.cpsc411_hw2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LableColumnGenerator (val ctx : Context) {

    fun generate(): LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.GREEN)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lbParams.weight = 1.0F
        lbParams.topMargin = 5

        var lbl = TextView(ctx)
        lbl.text = "Count:"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.rgb(204,241,255))
        layoutObj.addView(lbl, lbParams)

//        lbl = TextView(ctx)
//        lbl.text = "Date"
//        lbl.gravity = Gravity.CENTER
//        lbl.setBackgroundColor(Color.rgb(204,241,255))
//        layoutObj.addView(lbl, lbParams)

        //lbl = TextView(ctx)
        //lbl.text = "SSN"
        //lbl.setBackgroundColor(Color.YELLOW)
        //layoutObj.addView(lbl, lbParams)
        return layoutObj
    }
}