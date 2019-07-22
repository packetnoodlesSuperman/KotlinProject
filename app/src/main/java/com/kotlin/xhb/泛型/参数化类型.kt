package com.kotlin.xhb.泛型

class 参数化类型 {

    class Box<T>(t: T) {
        var value = t
    }

    val box = Box<Int>(1)


    fun <T> play(t: T) {
        //泛型方法
    }

}