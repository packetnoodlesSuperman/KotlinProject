package com.kotlin.xhb.okhttp

interface Call : Cloneable {

    fun request(): Request

    interface Factory {

        fun newCall(request: Request): Call

    }

}