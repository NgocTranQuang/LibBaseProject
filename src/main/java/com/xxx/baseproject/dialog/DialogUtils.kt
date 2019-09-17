package com.vn.custom.dialog

import android.content.Context
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import com.vn.custom.util.Constant
import com.xxx.baseproject.R


object DialogUtils {

    private fun AlertDialogTwoButton(
        context: Context,
        title: String?,
        message: String?,
        actionYes: (() -> Unit)?,
        actionNo: (() -> Unit
        )?
    ) {
        val builder = AlertDialog.Builder(context)

        // Set the alert dialog title
        builder.setTitle(handleMessageDialog(title))

        // Display a message on alert dialog
        builder.setMessage(handleMessageDialog(message))

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton(context.getString(R.string.key_yes)) { dialog, which ->
            actionYes?.invoke()
            dialog.dismiss()
        }


        // Display a negative button on alert dialog
        builder.setNegativeButton(context.getString(R.string.key_no)) { dialog, which ->
            actionNo?.invoke()
            dialog.dismiss()
        }


        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }

    private fun AlertDialogOneButton(
        context: Context,
        title: String?,
        message: String?,
        actionYes: (() -> Unit)?,
        actionBack: (() -> Unit
        )?
    ) {
        val builder = AlertDialog.Builder(context)

        // Set the alert dialog title
        builder.setTitle(handleMessageDialog(title))

        // Display a message on alert dialog
        builder.setMessage(handleMessageDialog(message))

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton(context.getString(R.string.key_ok)) { dialog, which ->
            actionYes?.invoke()
            dialog.dismiss()
        }
        builder.setOnDismissListener {
            actionBack?.invoke()
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
    private fun handleMessageDialog(message: String?): String {
        var msgToShow = ""
        if (TextUtils.isEmpty(message)) {
            msgToShow = ""
        } else {
            msgToShow = message ?: Constant.EMPTY_STRING
        }
        return msgToShow
    }
    fun showDialog(context: Context, message: String?) {
        this.AlertDialogOneButton(context, "", message, null, null)
    }

    fun showDialog(context: Context, message: String?, listenerDismiss: () -> Unit) {
        this.AlertDialogOneButton(context, "", message, null, listenerDismiss)
    }

    fun showDialog(context: Context, title: String?, message: String?) {
        this.AlertDialogOneButton(context, title, message, null, null)
    }


}