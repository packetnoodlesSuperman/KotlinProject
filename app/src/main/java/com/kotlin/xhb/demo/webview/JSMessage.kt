package com.kotlin.xhb.demo.webview

data class JSMessage(var action: String? = null,
                     var params: String? = null,
                     var callback: String? = null) {

    companion object {
        val ACTION = "nativeName"
        val PARAMS = "nativeParams"
        val CALLBACK = "callBack"
    }

}