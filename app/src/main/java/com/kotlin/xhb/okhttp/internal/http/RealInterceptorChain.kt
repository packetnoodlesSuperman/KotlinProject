package com.kotlin.xhb.okhttp.internal.http

import com.kotlin.xhb.okhttp.Call
import com.kotlin.xhb.okhttp.Interceptor
import com.kotlin.xhb.okhttp.Request
import com.kotlin.xhb.okhttp.Response
import com.kotlin.xhb.okhttp.internal.connection.Transmitter
import java.io.IOException

class RealInterceptorChain(
        private val interceptors: List<Interceptor>,
        private val transmitter: Transmitter,
        private val index: Int,
        private val request: Request,
        private val call: Call,
        private val connectTimeout: Int,
        private val readTimeout: Int,
        private val writeTimeout: Int
) : Interceptor.Chain {

    private var calls: Int = 0

    override fun request(): Request = request

    @Throws(IOException::class)
    override fun proceed(request: Request): Response {
        //夏海波 ---> require(index>= interceptors.size) { "" }
        if (index >= interceptors.size) throw AssertionError()

        calls++

        //TODO
    }

}