package com.kotlin.xhb.demo.webview

import com.kotlin.xhb.demo.showToast

class ToastAction: JSAction() {

    override fun action(jsMessage: JSMessage) {
        activity().showToast(jsMessage.params)
    }

}