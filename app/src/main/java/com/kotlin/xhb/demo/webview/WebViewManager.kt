package com.kotlin.xhb.demo.webview
import android.webkit.JavascriptInterface
import com.just.agentweb.AgentWeb

/**
 * @Desc 一个WebView对应一个Manager  也就是一个页面对应一个Manager
 *        所有的Manager都仅仅 指向唯一的 WebViewBuilder
 */
class WebViewManager {

    companion object {

        @JvmStatic
        @get:JvmName("webViewBuilder")
        lateinit var webViewBuilder: WebViewBuilder

        @JvmStatic
        fun builder(): WebViewBuilder {
            if (webViewBuilder == null) {
                synchronized (WebViewManager) {
                    if (webViewBuilder == null) {
                        webViewBuilder = WebViewBuilder();
                    }
                }
            }
            return webViewBuilder
        }
    }

    constructor(webViewBuilder: WebViewBuilder) {
        Companion.webViewBuilder = webViewBuilder;
        addJavascriptInterface(webViewBuilder.agentWeb);
    }

    fun addJavascriptInterface(agentWeb: AgentWeb) {
        agentWeb.getJsInterfaceHolder().addJavaObject(
                webViewBuilder.interfaceName, object : Any() {
                    @JavascriptInterface
                    fun openNative(jsonStr: String) {
                        webViewBuilder.jsHandler.handle(jsonStr);
                    }
                });
    }
}