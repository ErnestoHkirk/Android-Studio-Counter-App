package com.example.cpsc411_hw2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator (val ctx : Context){
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        // 1. Create a linearLayout object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.rgb(224, 224, 255))

        var lbl = TextView(ctx)
        lbl.setPadding(0,70,0,70)
        lbl.text = "RESTful Service and ListView Widget"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.rgb(255, 255, 224))
        lbl.textSize = 25F;
        layoutObj.addView(lbl)

        // 2. Add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        //

        // 3. Add Next Button LinearLayout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        // only applied to height now
        //nParams.weight = 0.0F
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.WHITE)
        //

        val nButton = Button(ctx)
        nButton.text = "Get Counter"
        nButton.setId(R.id.add_btn)
        nButton.setBackgroundColor(Color.rgb(255,204,225))
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        //
        layoutObj.addView(nLayout, nParams)

        var status = TextView(ctx)
        status.text = "List View:  ";
        status.setPadding(0,70,0,70)
        status.gravity = Gravity.CENTER
        status.setBackgroundColor(Color.rgb(255, 255, 224))
        status.textSize = 25F;
        layoutObj.addView(status)

        var value = TextView(ctx)
        value.id = R.id.status
        value.text = "-";
        value.setPadding(0,70,0,70)
        value.gravity = Gravity.CENTER
        value.setBackgroundColor(Color.rgb(238, 241, 230))
        value.textSize = 25F;
        layoutObj.addView(value)

        return layoutObj
    }
}