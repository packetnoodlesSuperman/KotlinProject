package com.kotlin.xhb.demo.webview

class JSMessage {

    lateinit var action: String
    lateinit var params: String
    lateinit var callback: String

    companion object {
        val ACTION = "nativeName"
        val PARAMS = "nativeParams"
        val CALLBACK = "callBack"
    }

}