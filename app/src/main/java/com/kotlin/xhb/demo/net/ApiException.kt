package com.kotlin.xhb.demo.net

class ApiException : RuntimeException {

    private var code: Int? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))

}