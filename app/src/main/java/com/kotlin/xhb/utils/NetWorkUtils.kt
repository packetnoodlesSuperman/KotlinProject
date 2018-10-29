package com.kotlin.xhb.utils

import android.content.Context
import android.net.ConnectivityManager
import com.kotlin.xhb.App

object NetWorkUtils {

    fun isNetWorkConnected(): Boolean {
        val cm = App.instance().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val currentNet = cm.activeNetworkInfo ?: return false
        return currentNet.isAvailable
    }

}