package com.kotlin.xhb.okhttp

/**
 * internal 权限修饰符 --> 在同一个模块内使用
 * https://github.com/square/okhttp/blob/master/okhttp/src/main/java/okhttp3/Request.kt
 */
open class OkHttpClient internal constructor(builder: Builder) : Call.Factory{



    override fun newCall(request: Request): Call {
        return RealCall.newRealCall(this, request, forWebSocket = false)
    }



    class Builder constructor() {

    }

}