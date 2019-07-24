package com.kotlin.xhb.demo

import android.content.Context
import android.widget.Toast

fun Context.showToast(content: String) {
    Toast.makeText(App.context, content, Toast.LENGTH_LONG).show()
}