package com.andiniaulia3119.dapurku.utils

import android.content.Context
import android.content.Intent

object ShareUtils {
    fun shareText(context: Context, title: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        context.startActivity(Intent.createChooser(intent, "Bagikan via"))
    }
}
