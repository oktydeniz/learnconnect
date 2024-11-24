package com.odeniz.learnconnect.util

import android.app.AlertDialog
import android.content.Context
import com.odeniz.learnconnect.R

fun showAlertDialog(context: Context, title: String, message: String, onOkClick: () -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setMessage(message)

    builder.setPositiveButton(context.getText(R.string.ok)) { dialog, which ->
        onOkClick()
    }

    builder.setNegativeButton(context.getText(R.string.cancel)) { dialog, which ->
        dialog.dismiss()
    }

    val dialog = builder.create()
    dialog.show()
}