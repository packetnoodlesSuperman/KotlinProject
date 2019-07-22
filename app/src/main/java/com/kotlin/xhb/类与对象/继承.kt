package com.kotlin.xhb.类与对象


open class 继承 : Any() {

    //所有类的超类  Any 下面是Any的三个函数
    //equals()
    //hashCode()
    //toString()

    open val age = 18

    open fun study() {
        println("我在学习")
    }


}