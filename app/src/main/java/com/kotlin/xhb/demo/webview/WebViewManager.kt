package com.kotlin.xhb.demo.webview
import android.webkit.JavascriptInterface
import com.just.agentweb.AgentWeb
class WebViewManager {

    fun addJavascriptInterface(agentWeb: AgentWeb) {
        agentWeb.getJsInterfaceHolder().addJavaObject("", object: Any() {
            @JavascriptInterface
            fun openNative(jsonStr: String) {

            }
        });
    }

}