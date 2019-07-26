package com.kotlin.xhb.demo.webview;

import android.app.Activity;

public abstract class JSAction {

    public WebViewBuilder webViewBuilder() {
        return WebViewManager.webViewBuilder();
    }

    public Activity activity() {
        return webViewBuilder().activity();
    }

    public void callback() {

    }

    public abstract void action(JSMessage jsMessage);

}
