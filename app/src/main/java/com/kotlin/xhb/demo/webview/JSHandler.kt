package com.kotlin.xhb.demo.webview

import android.os.Handler
import android.os.Looper
import org.json.JSONException
import org.json.JSONObject

class JSHandler {

    val mainHandler = Handler(Looper.getMainLooper())
    var jsActions: HashMap<String, JSAction>? = null

    fun handle(jsonStr: String) {
        if (jsonStr == null) {
            jsActions = HashMap()
        }
        try {
            var jsMessage = parseJSonString(jsonStr)
            var jsAction = getActionObject(jsActions!!, jsMessage)
            invokeHandler(jsAction, jsMessage)
        } catch (e: JSONException) {

        }

    }

    private fun getActionObject(jsActions: HashMap<String, JSAction>, jsMessage: JSMessage): JSAction {
        var jsAction = jsActions.get(jsMessage.action)
        if (jsAction == null) {
            //

        }
        return jsAction!!
    }

    @Throws(JSONException::class)
    private fun parseJSonString(jsonStr: String): JSMessage {
        return with(receiver = JSONObject(jsonStr)) {
            var jsMessage = JSMessage()
            jsMessage.action = getString(JSMessage.ACTION)
            jsMessage.params = getString(JSMessage.PARAMS)
            jsMessage.callback = getString(JSMessage.CALLBACK)
            return jsMessage
        }
    }


    private fun invokeHandler(jsAction: JSAction, jsMessage: JSMessage) {
        mainHandler.post({
            jsAction.action(jsMessage)
        })
    }
}