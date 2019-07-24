package com.kotlin.xhb.okhttp

import java.io.IOException

interface Interceptor {

    @Throws(IOException::class)
    fun intercept(chain: Chain): Response

    companion object {

        /**
         * https://blog.csdn.net/xfhy_/article/details/79153251
         * operator 将一个函数标记为重载一个操作符或者实现一个约定
         *
         * crossinline 的作用是让被标记的lambda表达式不允许非局部返回
         * 首先，默认内联函数的lambda表达式参数是允许非局部返回的
         */
        inline operator fun invoke(crossinline block: (chain: Chain) -> Response): Interceptor =
                object : Interceptor {
                    override fun intercept(chain: Chain) = block(chain)
                }

    }

    interface Chain {
        fun request(): Request

        @Throws(IOException::class)
        fun proceed(request: Request): Response
    }

}