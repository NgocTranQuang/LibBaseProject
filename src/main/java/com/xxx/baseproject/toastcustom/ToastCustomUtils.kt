package com.vn.custom.toastcustom

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.xxx.baseproject.R

object ToastCustomUtils {

    fun showCustomToast(context: Context, msg: String, bgColor: Int) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        val view = toast.view

        //To change the Background of Toast
        view.setBackgroundColor(bgColor)
        val text = view.findViewById<TextView>(android.R.id.message)
        text.setTextColor(Color.WHITE)

        toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, 0, 0)
        toast.show()
    }

    fun showErrorToast(context: Context, message: String) {
        showCustomToast(context, message, R.color.errorColorRed)
    }

    fun showSuccessToast(context: Context, message: String) {
        showCustomToast(context, message, R.color.successColorRed)
    }
}