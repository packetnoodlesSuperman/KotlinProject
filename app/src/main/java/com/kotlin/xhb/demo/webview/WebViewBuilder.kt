package com.kotlin.xhb.demo.webview

import android.app.Activity
import com.just.agentweb.AgentWeb

class WebViewBuilder {

    @JvmField
    val jsHandler = JSHandler()

    @get:JvmName("agentWeb")
    lateinit var agentWeb: AgentWeb

    @get:JvmName("interfaceName")
    lateinit var interfaceName: String

    @get:JvmName("url")
    lateinit var url: String

    @get:JvmName("activity")
    var activity: Activity? = null

    fun agentWeb(agentWeb: AgentWeb): WebViewBuilder = apply {
        this.agentWeb = agentWeb
    }

    fun interfaceName(interfaceName: String): WebViewBuilder = apply {
        this.interfaceName = interfaceName
    }

    fun url(url: String): WebViewBuilder = apply {
        this.url = url
    }

    fun url(activity: Activity): WebViewBuilder = apply {
        this.activity = activity
    }

    fun build(): WebViewManager = WebViewManager(this)

}